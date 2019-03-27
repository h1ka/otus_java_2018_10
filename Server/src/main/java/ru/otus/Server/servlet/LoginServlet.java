package ru.otus.Server.servlet;

import ru.otus.Server.AdminServer;
import ru.otus.Server.helper.TemplateProcessor;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "admin";
    private final static String MESSAGE_FOR_ERROR_LOGIN = "Either user name or password is wrong.";
    private final static String LOGIN_PAGE = "/login.ftl";

    public LoginServlet() {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost(request, response);
        if (request.getSession().getAttribute("name") != null){
            response.sendRedirect("/admin");
        } else {
            Map<String,Object> varMap = new HashMap<>();
            varMap.put("message","login : admin </br> password :  admin");
            response.getWriter().println(TemplateProcessor.instance().getPage(LOGIN_PAGE, varMap));
        }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (USERNAME.equals(name)&& LoginServlet.PASSWORD.equals(password)){
            response.getWriter().println("OK");
            HttpSession session = request.getSession();
            session.setAttribute("name",name);
            session.setMaxInactiveInterval(30);
            Cookie cookie = new Cookie("name",name);
            response.addCookie(cookie);
            request.getServletContext().setAttribute("name", name);
            response.sendRedirect("/admin");
        } else {
            Map<String,Object> varMap = new HashMap<>();
            varMap.put("message", MESSAGE_FOR_ERROR_LOGIN);
            String page = TemplateProcessor.instance().getPage(LOGIN_PAGE, varMap);
            response.getWriter().println(page);
        }

    }
}
