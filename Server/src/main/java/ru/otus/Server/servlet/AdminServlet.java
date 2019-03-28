package ru.otus.Server.servlet;

import ru.otus.Hibernate.dbservice.DbService;
import ru.otus.Hibernate.model.User;
import ru.otus.Server.helper.TemplateProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet
public class AdminServlet extends HttpServlet {

    private final DbService<User> dbService;


    public AdminServlet(DbService<User> dbService) {
        this.dbService = dbService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {

        if (request.getSession().getAttribute("name") != null) {
            response.getWriter().println(getPage(loadUsers()));
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.sendRedirect("/login");
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        User user = new User(id,name,age);

        dbService.save(user);

        response.getWriter().println(getPage(loadUsers()));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    private Map<String,Object> loadUsers(){
        Map<String,Object> varMap = new HashMap<>();
        List<User> users = dbService.loadAll("User", User.class);
        varMap.put("users", users);
        return varMap;
    }

    private String getPage(Map<String, Object> varMap) throws IOException {
        return TemplateProcessor.instance().getPage("admin.ftl", varMap);
    }
}
