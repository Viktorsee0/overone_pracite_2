package com.example.overone_pracite_2.validation;

import com.example.overone_pracite_2.dto.RegistrationDTO;
import com.example.overone_pracite_2.entity.User;
import com.example.overone_pracite_2.exception.RegistrationValidationException;
import com.example.overone_pracite_2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RegistrationValidation {

    private final UserService userService;


    private void validateEmail(String email){
        Optional<User> userByEmail = userService.getUserByEmail(email);

        if (!userByEmail.isEmpty()){
            throw new RegistrationValidationException("User with this email already exits");
        }

    }

    private void validatePassword(String password, String repassword){

        if (!password.equals(repassword)){
            throw new RegistrationValidationException("Passwords mismatched");
        }

    }

    private void validateNames(String firstName, String secondName){

        if (firstName.isEmpty() || secondName.isEmpty()){
            throw new RegistrationValidationException("firstName and firstName can't be empty");
        }

    }

    public void validate(RegistrationDTO dto){
        validateEmail(dto.getEmail());
        validatePassword(dto.getPassword(), dto.getRepassword());
        validateNames(dto.getFirstName(), dto.getSecondName());

    }


}
