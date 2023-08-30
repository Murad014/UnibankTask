package com.unibanktask.unibank.tools;

import com.unibanktask.unibank.dto.UserDto;
import com.unibanktask.unibank.entity.User;

public class CreateClasses {
    public static User createUser(){
        User user = new User();
        user.setName("Murad");
        user.setSurname("Guliyev");
        user.setPin("0023");
        user.setPassword("test1231");

        return user;
    }

    public static UserDto createUserDto(){
        UserDto userDto = new UserDto();
        userDto.setName("Murad");
        userDto.setSurname("Guliyev");
        userDto.setPin("0023");
        userDto.setPassword("test1231");

        return userDto;
    }

}
