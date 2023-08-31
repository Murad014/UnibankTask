package com.unibanktask.unibank.service.impl;

import com.unibanktask.unibank.dto.response.CurrencyRates;
import com.unibanktask.unibank.dto.response.CurrencyResponse;
import com.unibanktask.unibank.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CacheManager cacheManager;

    private Random random = new Random();

    @Cacheable("currencyRates")
    public Double getCurrencyRate(String currencyPair) {
        return random.nextDouble() * 10;
    }

    @Scheduled(fixedRate = 60000) // 1 minn
    public CurrencyResponse getCurrencyRateFromCache() {
        List<String> currencyPairs = Arrays.asList("USD/AZN", "AZN/TL");
        List<CurrencyRates> rates = new ArrayList<>();

        for (String currencyPair : currencyPairs) {
            Double newRate = getCurrencyRate(currencyPair);
            CurrencyRates currency = new CurrencyRates();
            currency.setPair(currencyPair);
            currency.setRate(newRate);
            rates.add(currency);

            Objects.requireNonNull(cacheManager.getCache("currencyRates")).put(currencyPair, newRate);
        }

        CurrencyResponse currencyResponse = new CurrencyResponse();
        currencyResponse.setCurrencyRates(rates);

        return currencyResponse;
    }
}
