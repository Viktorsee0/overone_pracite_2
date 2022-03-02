package com.example.overone_pracite_2.service;

import com.example.overone_pracite_2.dto.RegistrationDTO;
import com.example.overone_pracite_2.entity.User;
import com.example.overone_pracite_2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void register(RegistrationDTO dto){
        User user = User.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .secondName(dto.getSecondName())
                .password(dto.getPassword())
                .build();

        userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public User getUserById(String id){
        return userRepository.getById(id);
    }

}
