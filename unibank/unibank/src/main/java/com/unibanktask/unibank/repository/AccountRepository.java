package com.unibanktask.unibank.repository;

import com.unibanktask.unibank.dto.AccountDto;
import com.unibanktask.unibank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);

}
