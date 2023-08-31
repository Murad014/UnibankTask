package com.unibanktask.unibank.service;

import com.unibanktask.unibank.dto.UserDto;

public interface UserService {

    String createUser(UserDto userDto);
    String login(UserDto loginDto);

}
