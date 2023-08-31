package com.unibanktask.unibank.user;

import com.unibanktask.unibank.dto.UserDto;
import com.unibanktask.unibank.entity.Role;
import com.unibanktask.unibank.entity.User;
import com.unibanktask.unibank.repository.RoleRepository;
import com.unibanktask.unibank.repository.UserRepository;
import com.unibanktask.unibank.security.JwtTokenProvider;
import com.unibanktask.unibank.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
    @Test
    public void testLogin() {

        UserDto loginDto = new UserDto();
        loginDto.setPin("userPin");
        loginDto.setPassword("userPassword");

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any())).thenReturn(authentication);

        when(jwtTokenProvider.generateToken(authentication)).thenReturn("mockedToken");

        // When
        String token = userService.login(loginDto);

        // Then
        verify(authenticationManager).authenticate(any());
        verify(jwtTokenProvider).generateToken(authentication);

        assertEquals("mockedToken", token);
    }

}
