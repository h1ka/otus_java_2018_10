package ru.otus.DI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ru.otus.DI.DBInitialize;
import ru.otus.DI.dbservice.DbService;
import ru.otus.DI.model.User;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController {

    DbService dbService;

    @Autowired
    public UserController(DbService dbService) {
        this.dbService = dbService;
    }

    @GetMapping("/")
    public String index(ModelMap map){
        return "index.html";
    }

    @GetMapping("/list")
    public String listUsers(Model map){

        List<User> users = dbService.loadAll("User", User.class);
        map.addAttribute("users",users);
        return "list.html";
    }
    @GetMapping("user/create")
    public String createUser(Model map){
        int i = dbService.loadAll("User", User.class).size();
        long id = i+1;
        User user = new User();
        user.setId(id);
        map.addAttribute("user",user);
        return "userCreate.html";
    }

    @PostMapping("/user/save")
    public RedirectView saveUser(@RequestParam("id") int id,@RequestParam("name")String name,@RequestParam("age")Integer age, Model model){
            User newUser = new User(id,name,age);
            dbService.save(newUser);

        return new RedirectView("/list", true);

    }
    @GetMapping("/edit")
    public String editPage(@RequestParam("id") int id, Model model) {
        User user = (User) dbService.load(id,User.class);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String savePage(@RequestParam("id") int id,@RequestParam("newName")String name,@RequestParam("age")Integer age, Model model) {
        User user = (User) dbService.load(id,User.class);
        user.setName(name);
        user.setAge(age);
        dbService.save(user);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostConstruct
    public void init() throws SQLException {
        DBInitialize q = new DBInitialize();
        q.start();
    }
}
