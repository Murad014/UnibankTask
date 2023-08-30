package com.unibanktask.unibank.dto;


import com.unibanktask.unibank.customvalidation.UniquePin;
import com.unibanktask.unibank.entity.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransferDto {

    private Long id;

    private Account senderAccount;

    private Account receiverAccount;

    private BigDecimal amount;

}
