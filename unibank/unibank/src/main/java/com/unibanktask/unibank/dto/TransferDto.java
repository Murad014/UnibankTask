package com.unibanktask.unibank.dto;


import com.unibanktask.unibank.customvalidation.UniquePin;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferDto {

    @UniquePin()
    private String receiverPin;
    private String senderPin;

    private BigDecimal amount;
}
