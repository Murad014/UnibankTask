package com.unibanktask.unibank.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class TransferBalanceException extends RuntimeException{

    private final BigDecimal balance;
    public TransferBalanceException(BigDecimal balance) {
        super(String.format("In order to transfer your balance is not enough. Your balance: %s", balance.toString()));
        this.balance = balance;
    }
}
