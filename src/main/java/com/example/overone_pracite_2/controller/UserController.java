package com.example.overone_pracite_2.controller;

import com.example.overone_pracite_2.entity.User;
import com.example.overone_pracite_2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user_page";
    }

}
