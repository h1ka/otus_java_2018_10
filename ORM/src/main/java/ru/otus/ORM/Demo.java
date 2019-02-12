package ru.otus.ORM;

import ru.otus.ORM.dao.TestUser;
import ru.otus.ORM.dao.User;
import ru.otus.ORM.dbservice.DataSourceH2;
import ru.otus.ORM.dbservice.DbService;
import ru.otus.ORM.dbservice.DbServiceImpl;
import ru.otus.ORM.executor.DbExecutor;
import ru.otus.ORM.executor.DbExecutorImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {



    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new DataSourceH2();
        Demo demo = new Demo();
        demo.createTable(dataSource);
        long id = 1;
        User user = new User(1l,"Nika",23);
        User notUser = new User(1l,"NotNika",25);
        User user2 = new User(2l,"User2",25);
        DbService<User> dbService = new DbServiceImpl<>(dataSource);
        dbService.save(user);
        User u1 = dbService.load(id, User.class);
        System.out.println(u1);
        dbService.save(notUser);
        u1 = dbService.load(id, User.class);
        System.out.println(u1);
        dbService.save(user2);
        User u2 = dbService.load(2, User.class);
        System.out.println(u2);


    }

    private void createTable(DataSource dataSource) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement("create table User(id long auto_increment, name varchar(255), age int(3))")) {
            pst.executeUpdate();
        }
        System.out.println("table created");
    }
}
