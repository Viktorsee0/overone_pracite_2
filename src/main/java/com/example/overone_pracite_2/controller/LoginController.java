package com.example.overone_pracite_2.controller;

import com.example.overone_pracite_2.dto.LoginDTO;
import com.example.overone_pracite_2.entity.User;
import com.example.overone_pracite_2.exception.LoginValidationException;
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
@RequiredArgsConstructor
public class LoginController {

    private final LoginValidation loginValidation;
    private final UserService userService;

    @GetMapping({"/", "/login"})
    public String showLoginPage(Model model){
        model.addAttribute("user", new LoginDTO());
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") LoginDTO dto, Model model) {

        try {
            loginValidation.validate(dto);
        } catch (LoginValidationException ex) {
            model.addAttribute("message", ex.getMessage());
            return "login_page";
        }

        User currentUser = userService.getUserByEmail(dto.getEmail()).get();

        return "redirect:/user/" + currentUser.getId();
    }

}
