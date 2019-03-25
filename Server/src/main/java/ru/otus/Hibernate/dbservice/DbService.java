package ru.otus.Hibernate.dbservice;

import java.util.List;

public interface DbService<T> {
    void save(T objectData);
    <T> T load(long id, Class<T> clazz);
    List<T> loadAll(String tableName, Class<T> clazz);
}