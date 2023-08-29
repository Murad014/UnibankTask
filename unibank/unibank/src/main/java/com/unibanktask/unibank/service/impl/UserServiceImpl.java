package com.unibanktask.unibank.service.impl;


import com.unibanktask.unibank.dto.UserDto;
import com.unibanktask.unibank.entity.User;
import com.unibanktask.unibank.repository.UserRepository;
import com.unibanktask.unibank.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper
                         /*  BCryptPasswordEncoder bCryptPasswordEncoder */ ){

        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
//        String hashedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
        User newUser = userRepository.save(dtoToEntity(userDto));
        return entityToDto(newUser);
    }

    private UserDto entityToDto(User user){
        return  modelMapper.map(user, UserDto.class);
    }

    private User dtoToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }



}
