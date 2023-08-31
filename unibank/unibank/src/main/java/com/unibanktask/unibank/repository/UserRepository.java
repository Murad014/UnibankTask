package com.unibanktask.unibank.repository;

import com.unibanktask.unibank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByPin(String pin);

    Optional<User> findByPin(String pin);

}
