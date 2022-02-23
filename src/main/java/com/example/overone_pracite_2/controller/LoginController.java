package com.example.overone_pracite_2.controller;

import com.example.overone_pracite_2.dto.RegistrationDTO;
import com.example.overone_pracite_2.entity.User;
import com.example.overone_pracite_2.exception.RegistrationValidationException;
import com.example.overone_pracite_2.service.UserService;
import com.example.overone_pracite_2.validation.LoginValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginValidation loginValidation;
    private final UserService userService;

    @GetMapping
    public String showLoginPage(Model model){
        model.addAttribute("user", new User());
        return "login_page";
    }

    @PostMapping
    public String login(@ModelAttribute("user") User user, Model model) {

        try {
            loginValidation.validate(user);
        } catch (RegistrationValidationException ex) {
            model.addAttribute("message", ex.getMessage());
            return "login_page";
        }

        User currentUser = userService.getUserByEmail(user.getEmail()).get();

        return "redirect:/" + currentUser.getId();
    }

}