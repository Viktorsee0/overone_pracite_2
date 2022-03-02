package com.example.overone_pracite_2.dto;

import lombok.*;


@Data
public class RegistrationDTO {
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String repassword;
}
