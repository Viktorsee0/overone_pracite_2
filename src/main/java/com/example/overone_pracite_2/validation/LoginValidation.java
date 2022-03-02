package com.example.overone_pracite_2.validation;

import com.example.overone_pracite_2.dto.LoginDTO;
import com.example.overone_pracite_2.entity.User;
import com.example.overone_pracite_2.exception.LoginValidationException;
import com.example.overone_pracite_2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoginValidation {

    private final UserService userService;

    public void validate(LoginDTO dto){
        Optional<User> userByEmail = userService.getUserByEmail(dto.getEmail());

        if (userByEmail.isEmpty()){
            throw new LoginValidationException("User with this email doesn't exits");
        }

        if (!userByEmail.get().getPassword().equals(dto.getPassword())){
            throw new LoginValidationException("Password doesn't correct");
        }
    }


}
