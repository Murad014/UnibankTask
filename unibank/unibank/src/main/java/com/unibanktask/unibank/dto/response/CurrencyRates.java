package com.unibanktask.unibank.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyRates {
    private String pair;
    private double rate;
}