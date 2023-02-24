package ru.sinforge.practice24.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sinforge.practice24.Entities.MyUser;
import ru.sinforge.practice24.Services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration() {
        return "reg";
    }

    @PostMapping("/registration")
    public String AddUser(MyUser user, Model model) {
        if (!userService.addUser(user.getUsername(), user.getPassword())) {
            return "reg";
        }
        return "redirect:/login";
    }
}
