package com.unibanktask.unibank.service;

import com.unibanktask.unibank.dto.UserDto;
import com.unibanktask.unibank.dto.request.LoginRequest;

public interface UserService {

    String createUser(UserDto userDto);
    String login(LoginRequest loginRequest);

}
