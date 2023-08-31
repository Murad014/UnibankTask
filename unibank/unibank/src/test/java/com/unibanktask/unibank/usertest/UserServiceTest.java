//package com.unibanktask.unibank.usertest;
//import com.unibanktask.unibank.UnibankApplication;
//import com.unibanktask.unibank.dto.UserDto;
//import com.unibanktask.unibank.entity.User;
//import com.unibanktask.unibank.repository.UserRepository;
//import com.unibanktask.unibank.service.impl.UserServiceImpl;
//import com.unibanktask.unibank.tools.CreateClasses;
//import org.junit.jupiter.api.DisplayName;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.modelmapper.ModelMapper;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//import static com.unibanktask.unibank.tools.CreateClasses.*;
//
//@SpringBootTest
//public class UserServiceTest {
//    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private ModelMapper modelMapper;
//
////    @MockBean
////    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
////    @BeforeEach
////    void setUp() {
////        MockitoAnnotations.openMocks(this);
////    }
//
//    @Test
//    @DisplayName("Check Create User (Service)")
//    void testCreateUser() {
//        User userEntity = createUser();
//        UserDto userDto = createUserDto();
////        String hashCode = bCryptPasswordEncoder.encode(userEntity.getPassword());
////        userEntity.setPassword(hashCode);
//
//        when(userRepository.save(userEntity)).thenReturn(userEntity);
//        when(modelMapper.map(userEntity, UserDto.class)).thenReturn(userDto);
////        when(bCryptPasswordEncoder.encode("testPassword")).thenReturn("hashedPassword");
//
////        UserDto createdUserDto = userService.createUser(userDto);
////        verify(bCryptPasswordEncoder).encode("testPassword");
//        verify(userRepository).save(any(User.class));
//        verify(modelMapper).map(userEntity, UserDto.class);
//
//        assertAll(
//                () -> assertEquals("Murad", createdUserDto.getName()),
//                () -> assertEquals("Guliyev", createdUserDto.getSurname()),
//                () -> assertEquals("0023", createdUserDto.getPin()),
//                () -> assertEquals("test1231", createdUserDto.getPassword())
//        );
//
//
//
//    }
//}
