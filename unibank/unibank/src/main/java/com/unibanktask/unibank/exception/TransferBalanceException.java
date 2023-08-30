package com.unibanktask.unibank.exception;

import java.math.BigDecimal;

public class TransferBalanceException extends RuntimeException{

    private final BigDecimal balance;
    public TransferBalanceException(BigDecimal balance) {
        super(String.format("In order to transfer your balance is not enough. Your balance: %s", balance.toString()));
        this.balance = balance;
    }
}
