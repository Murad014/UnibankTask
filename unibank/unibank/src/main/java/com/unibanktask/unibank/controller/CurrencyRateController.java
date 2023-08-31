package com.unibanktask.unibank.controller;

import com.unibanktask.unibank.dto.response.CurrencyResponse;
import com.unibanktask.unibank.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyRateController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyRateController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    @Operation(summary = "Get Currency Rate")
    public ResponseEntity<CurrencyResponse> getCurrencyRate() {
        CurrencyResponse response = currencyService.getCurrencyRateFromCache();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
