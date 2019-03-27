package ru.otus.Server;

import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import ru.otus.Hibernate.LoadingDB;
import ru.otus.Hibernate.dbservice.DbServiceHibernate;
import ru.otus.Server.servlet.AdminServlet;
import ru.otus.Server.servlet.LoginServlet;
import ru.otus.Server.servlet.LogoutServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

public class AdminServer {
    private final int PORT ;
    private final static String PUBLIC_HTML = "/static";

    private AdminServer() {
        this.PORT=8080;
    }

    private AdminServer(int PORT) {
        this.PORT = PORT;
    }

    static AdminServer instance;

    public static AdminServer instanceAdminServer(int PORT){
        if(instance==null) {
            instance=new AdminServer(PORT);
        }
        return instance;
    }

    public static AdminServer instanceAdminServer(){
        if(instance==null) {
            instance=new AdminServer();
        }
        return instance;
    }



    public void start() throws Exception {

//        try {
//            LoadingDB.start();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        ResourceHandler resourceHandler = new ResourceHandler();
        Resource resource = Resource.newClassPathResource(PUBLIC_HTML);
        resourceHandler.setBaseResource(resource);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new LoginServlet()),"/login");

        context.addServlet(new ServletHolder(new AdminServlet(new DbServiceHibernate<>())),"/admin");

        context.addServlet(new ServletHolder(new LogoutServlet()),"/logout");
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(PORT);
        server.setHandler(new HandlerList(resourceHandler, context));

        server.start();
        server.join();
    }


}
