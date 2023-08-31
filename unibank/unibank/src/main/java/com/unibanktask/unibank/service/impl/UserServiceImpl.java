package com.unibanktask.unibank.service.impl;


import com.unibanktask.unibank.dto.UserDto;
import com.unibanktask.unibank.dto.request.LoginRequest;
import com.unibanktask.unibank.entity.Role;
import com.unibanktask.unibank.entity.User;
import com.unibanktask.unibank.repository.RoleRepository;
import com.unibanktask.unibank.repository.UserRepository;
import com.unibanktask.unibank.security.JwtTokenProvider;
import com.unibanktask.unibank.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private AuthenticationManager authenticationManager;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper,
                           AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.modelMapper = modelMapper;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String createUser(UserDto userDto) {
        User user = dtoToEntity(userDto);

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName("ROLE_USER").orElse(null);
        roles.add(userRole);

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);

        return "User created successfully";
    }
    @Override
    public String login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getPin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenProvider.generateToken(authentication);
    }

    public UserDto entityToDto(User user){
        return  modelMapper.map(user, UserDto.class);
    }

    public User dtoToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }



}
