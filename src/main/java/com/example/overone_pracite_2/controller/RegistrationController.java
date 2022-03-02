package com.example.overone_pracite_2.controller;

import com.example.overone_pracite_2.dto.RegistrationDTO;
import com.example.overone_pracite_2.exception.RegistrationValidationException;
import com.example.overone_pracite_2.service.UserService;
import com.example.overone_pracite_2.validation.RegistrationValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final RegistrationValidation registrationValidation;

    @GetMapping
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new RegistrationDTO());
        return "registration_page";
    }


    @PostMapping
    public String registration(@ModelAttribute("user") RegistrationDTO dto,Model model) {
        try {
            registrationValidation.validate(dto);
        } catch (RegistrationValidationException ex) {
            model.addAttribute("message", ex.getMessage());
            return "registration_page";
        }
        userService.register(dto);
        return "redirect:/successful_registration";
    }

}
