package com.unibanktask.unibank.service;

import com.unibanktask.unibank.dto.AccountDto;
import com.unibanktask.unibank.entity.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto, Long userId);
    List<AccountDto> fetchAllAccountsByUserId(Long userId);

    void transferProccess(Long receiverAccoundId, Long senderAccountId, BigDecimal amount);

}
