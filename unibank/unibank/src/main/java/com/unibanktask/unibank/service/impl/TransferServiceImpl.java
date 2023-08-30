package com.unibanktask.unibank.service.impl;

import com.unibanktask.unibank.dto.TransferDto;
import com.unibanktask.unibank.entity.Account;
import com.unibanktask.unibank.entity.Transfer;
import com.unibanktask.unibank.exception.ResourceNotFoundException;
import com.unibanktask.unibank.repository.AccountRepository;
import com.unibanktask.unibank.repository.TransferRepository;
import com.unibanktask.unibank.service.TransferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TransferServiceImpl(TransferRepository transferRepository,
                               AccountRepository accountRepository,
                               ModelMapper modelMapper){
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransferDto createTransfer(Long senderAccountId,
                                      Long receiverAccountId, BigDecimal amount) {

        Account senderAccount = accountRepository.findById(senderAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Sender Account 2302", "senderPin", senderAccountId));

        Account receiverAccount = accountRepository.findById(receiverAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Receiver Account 0211", "id", receiverAccountId));

        Transfer transfer = new Transfer();
        transfer.setAmount(amount);
        transfer.setReceiverAccount(receiverAccount);
        transfer.setSenderAccount(senderAccount);

        return entityToDto(transferRepository.save(transfer));
    }

    private TransferDto entityToDto(Transfer transfer){
        return  modelMapper.map(transfer, TransferDto.class);
    }

    private Transfer dtoToEntity(TransferDto transferDto){
        return modelMapper.map(transferDto, Transfer.class);
    }
}
