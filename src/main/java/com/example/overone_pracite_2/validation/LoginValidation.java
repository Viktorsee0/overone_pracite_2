package com.example.overone_pracite_2.validation;

import com.example.overone_pracite_2.dto.RegistrationDTO;
import com.example.overone_pracite_2.entity.User;
import com.example.overone_pracite_2.exception.RegistrationValidationException;
import com.example.overone_pracite_2.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoginValidation {


    private final UserService userService;


    public void validate(User user){
        Optional<User> userByEmail = userService.getUserByEmail(user.getEmail());

        if (userByEmail.isEmpty()){
            throw new RegistrationValidationException("User with this email doesn't exits");
        }

        if (!userByEmail.get().getPassword().equals(user.getPassword())){
            throw new RegistrationValidationException("Password doesn't correct");
        }
    }


}
