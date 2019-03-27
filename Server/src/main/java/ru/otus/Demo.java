package ru.otus;

import ru.otus.Hibernate.LoadingDB;
import ru.otus.Server.AdminServer;

public class Demo {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        AdminServer.instanceAdminServer(PORT).start();

    }
}
