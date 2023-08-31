package com.unibanktask.unibank.repository;

import com.unibanktask.unibank.dto.AccountDto;
import com.unibanktask.unibank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);
    List<Account> findByUserPin(String userPin);
    List<Account> findByUserPinAndIsActiveTrue(String userPin);

}
