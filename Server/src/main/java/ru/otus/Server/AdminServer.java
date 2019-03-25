package ru.otus.Server;

import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import ru.otus.Hibernate.dbservice.DbServiceHibernate;
import ru.otus.Server.servlet.AdminServlet;
import ru.otus.Server.servlet.LoginServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class AdminServer {
    private final static int PORT = 8088;
    private final static String PUBLIC_HTML = "/WEB-INF/view";

    public static void main(String[] args) {
        AdminServer adminServer = new AdminServer();

        try {
            adminServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void start() throws Exception {
//        resourcesExample();

        ResourceHandler resourceHandler = new ResourceHandler();
        Resource resource = Resource.newClassPathResource(PUBLIC_HTML);
        resourceHandler.setBaseResource(resource);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new LoginServlet()),"/login");

        context.addServlet(new ServletHolder(new AdminServlet(new DbServiceHibernate<>())),"/admin");

        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(PORT);
        server.setHandler(new HandlerList(resourceHandler, context));

        server.start();
        server.join();
    }


}
