package ru.otus.Server.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.otus.Server.helper.TemplateProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private final static String username = "admin";
    private final static String password = "admin";
    private final static String messageForErrorLogin = "Either user name or password is wrong.";

    public LoginServlet() {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (username.equals(name)&& LoginServlet.password.equals(password)){
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
            varMap.put("message",messageForErrorLogin);
            String page = TemplateProcessor.instance().getPage("index.html", varMap);
            response.getWriter().println(page);
        }

    }
}
