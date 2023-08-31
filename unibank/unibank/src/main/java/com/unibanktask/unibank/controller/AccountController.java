package com.unibanktask.unibank.controller;

import com.unibanktask.unibank.dto.AccountDto;
import com.unibanktask.unibank.security.JwtTokenProvider;
import com.unibanktask.unibank.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/users/accounts")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(
                accountService.createAccount(accountDto, JwtTokenProvider.userPin),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/users/accounts")
    public ResponseEntity<List<AccountDto>> fetchAllAccounts(){
        return new ResponseEntity<>(
                accountService.fetchAllAccountsByUserPin(JwtTokenProvider.userPin),
                HttpStatus.OK);
    }




}
