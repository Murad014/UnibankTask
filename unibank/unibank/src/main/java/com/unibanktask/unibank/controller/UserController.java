package com.unibanktask.unibank.controller;

import com.unibanktask.unibank.dto.UserDto;
import com.unibanktask.unibank.entity.User;
import com.unibanktask.unibank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> fetchAllUsers(){
        return userRepository.findAll();

    }
}
