package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/dangky")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "/formCreate";

    }

    @PostMapping("/create")
    public String form(@Validated @ModelAttribute(value = "user") User user,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/formCreate";
        }

        service.createUser(user);
        return "/success";


    }
}
