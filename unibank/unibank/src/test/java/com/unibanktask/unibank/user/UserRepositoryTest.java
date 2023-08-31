package com.unibanktask.unibank.user;

import com.unibanktask.unibank.entity.User;
import com.unibanktask.unibank.repository.UserRepository;
import com.unibanktask.unibank.tools.CreateClasses;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private static User user;

    @BeforeAll
    public static void beforeAll(){
        user = CreateClasses.createUser();
    }
    private final static String testPin = "4123123";

    @Test
    public void testCreateUser(){
        userRepository.save(user);
        User userFromDB = userRepository.findById(user.getId()).orElse(new User());

        assertThat(userFromDB.getName()).isEqualTo(user.getName());
        assertThat(userFromDB.getSurname()).isEqualTo(user.getSurname());
        assertThat(userFromDB.getPin()).isEqualTo(user.getPin());
        assertThat(userFromDB.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void testFindByPin(){
        userRepository.save(user);
        User userFromDB = userRepository.findByPin(user.getPin()).orElse(new User());
        assertThat(userFromDB.getPin()).isEqualTo(user.getPin());
    }

    @Test
    public void testExistsByPin(){
        User userFromDB = userRepository.save(user);
        boolean exist = userRepository.existsByPin(user.getPin());
        assertThat(exist).isTrue();

        boolean notExist = userRepository.existsByPin(testPin);
        assertThat(notExist).isFalse();
    }

}