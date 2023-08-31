package com.unibanktask.unibank.service;

import com.unibanktask.unibank.dto.TransferDto;
import com.unibanktask.unibank.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface TransferService {

    TransferDto createTransfer(Long senderAccountId,
                               Long receiverAccountId,
                               BigDecimal amount);




}
