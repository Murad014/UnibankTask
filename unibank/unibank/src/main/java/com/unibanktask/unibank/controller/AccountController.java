package com.unibanktask.unibank.controller;

import com.unibanktask.unibank.dto.AccountDto;
import com.unibanktask.unibank.security.JwtTokenProvider;
import com.unibanktask.unibank.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Create Account", description = "Reference to userPin." +
            "Actually this process operated by Admin. But Documentation that you provided there is not task about it" +
            " so I allow creates accounts to users and set balance by themselves in order to simply.")

    @PostMapping("/users/accounts")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(
                accountService.createAccount(accountDto, JwtTokenProvider.userPin),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/users/accounts")
    @Operation(summary = "Fetch All Accounts", description = "Reference to userPin")
    public ResponseEntity<List<AccountDto>> fetchAllAccounts(){
        return new ResponseEntity<>(
                accountService.fetchAllAccountsByUserPin(JwtTokenProvider.userPin),
                HttpStatus.OK);
    }




}
