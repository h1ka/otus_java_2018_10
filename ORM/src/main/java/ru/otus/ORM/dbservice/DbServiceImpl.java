package ru.otus.ORM.dbservice;

import ru.otus.ORM.dao.User;
import ru.otus.ORM.executor.DbExecutor;
import ru.otus.ORM.executor.DbExecutorImpl;
import ru.otus.ORM.reflection.ReflectionClass;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class DbServiceImpl<T> implements DbService<T> {
    private final DataSource dataSource;

    public DbServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(T objectData) {
        boolean emptyLoad = isEmptyLoad(objectData);

        
        if(emptyLoad){
            insert(objectData);
        } else {
            update(objectData);
        }

    }

    private void insert(T objectData){
        String tableName = objectData.getClass().getSimpleName();

        System.out.println("insert");

        try (Connection connection = dataSource.getConnection()) {
            DbExecutor<T> executor = new DbExecutorImpl<>(connection);
            List<String> countValues = new ArrayList<>();
            List<String> valuesFields = ReflectionClass.getValuesFields(objectData);

            for (var el : valuesFields){
                countValues.add("?");
            }

            String joinedCountValues = countValues.stream()
                    .collect(Collectors.joining(","));

            String sql = String.format("insert into %s values (%s)",tableName,joinedCountValues);
            executor.insertRecord(sql, valuesFields);
            connection.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    private void update(T objectData){
        var fieldId =
                ReflectionClass.getFieldWithAnnotationId(objectData.getClass());
        String tableName = objectData.getClass().getSimpleName();

        Map<String,String> fieldWithValue = ReflectionClass.getFieldWithValue(objectData);

        System.out.println("update");
        try(Connection connection = dataSource.getConnection()){
            DbExecutor<T> executor = new DbExecutorImpl<>(connection);

            List<String> columnNames = ReflectionClass.getNamesField(objectData,fieldId);
            List<String> countValues = new ArrayList<>();
            List<String> valuesFields = ReflectionClass.getValuesFields(objectData,fieldId);
            valuesFields.add(ReflectionClass.getFieldValue(objectData,fieldId.getName()).toString());

            for (var el : fieldWithValue.keySet()){
                if (el!=fieldId.getName()) {
                    countValues.add("?");
                }
            }
            String joinedColumnNames = columnNames.stream()
                    .collect(Collectors.joining(","));

            String joinedCountValues = countValues.stream()
                    .collect(Collectors.joining(","));

            String sql = String.format("UPDATE %s set (%s) = (%s) where %s=?",
                    tableName,joinedColumnNames,joinedCountValues,fieldId.getName());


            executor.insertRecord(sql, valuesFields);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    private boolean isEmptyLoad(T objectData){
        var fieldId =
                ReflectionClass.getFieldWithAnnotationId(objectData.getClass());
        if(fieldId==null) {
            throw new RuntimeException("Not found field with annotation \"Id\"");
        }
        var fieldValue =
                ReflectionClass.getFieldValue(objectData, fieldId.getName());
        var load = load((Long) fieldValue, objectData.getClass());
        if(load==null) return true;
        else return false;
    }

    @Override
    public <T> T load(long id, Class<T> clazz) {
        String tableName = clazz.getSimpleName();
        String fieldId =
                ReflectionClass.getFieldWithAnnotationId(clazz).getName();
        int countFields = clazz.getDeclaredFields().length;

        try (Connection connection = dataSource.getConnection()) {
            DbExecutor<T> executor = new DbExecutorImpl<>(connection);
            String sql = String.format("select * from %s where %s  = ?",tableName,fieldId);

            Optional<T> user = executor.selectRecord(sql, id, resultSet -> {
                try {
                    Object[] objects = new Object[countFields];
                    if (resultSet.next()){
                    for (int i = 0;i<countFields;i++) {
                        Object resultSetObject = resultSet.getObject(i + 1);
                        objects[i] = resultSetObject;
                    }
                        Object object =ReflectionClass.instantiate(clazz,objects);
                        return (T) object;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            });

            if(user!=Optional.empty()){
                return user.get();
            }else return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }
}
