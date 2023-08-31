package com.unibanktask.unibank.service;

import com.unibanktask.unibank.dto.response.CurrencyResponse;

public interface CurrencyService {
    CurrencyResponse getCurrencyRateFromCache();
}
