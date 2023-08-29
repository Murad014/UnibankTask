package com.unibanktask.unibank.usertest;


import com.unibanktask.unibank.entity.User;
import com.unibanktask.unibank.repository.UserRepository;
import com.unibanktask.unibank.tools.CreateClasses;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import static com.unibanktask.unibank.tools.CreateClasses.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestPropertySource(locations = "classpath:application-test.properties")
public class UserRepositoryTest {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Test
    @DisplayName("Exists pin")
    @Order(1)
    void testExistsByPinWhenPinExists() {
        String existingPin = "0023";
        userRepository.save(createUser());
        boolean existsStatus = userRepository.existsByPin(existingPin);
        assertTrue(existsStatus);
    }

    @Test
    @DisplayName("Does not exist pin")
    @Order(2)
    void testExistsByPin_WhenPinDoesNotExist() {
        String nonExistingPin = "3412";
        userRepository.save(createUser());
        boolean result = userRepository.existsByPin(nonExistingPin);

        assertFalse(result);
    }

    @Test
    @DisplayName("Create User")
    @Order(3)
    void testCreateUser(){
        User newUser = userRepository.save(CreateClasses.createUser());
        User userFromDB = userRepository.findById(newUser.getId()).orElse(
                new User()
        );

        assertEquals(newUser.getName(), userFromDB.getName());
        assertEquals(newUser.getSurname(), userFromDB.getSurname());
        assertEquals(newUser.getPassword(), userFromDB.getPassword());
        assertEquals(newUser.getPin(), userFromDB.getPin());

    }








}
