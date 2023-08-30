package com.unibanktask.unibank.controller;

import com.unibanktask.unibank.dto.TransferDto;
import com.unibanktask.unibank.dto.request.TransferRequest;
import com.unibanktask.unibank.dto.response.TransferResponseDto;
import com.unibanktask.unibank.service.AccountService;
import com.unibanktask.unibank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TransferController {

    private final TransferService transferService;
    private final AccountService accountService;
    @Autowired
    public TransferController(TransferService transferService,
                                                 AccountService accountService){
        this.transferService = transferService;
        this.accountService = accountService;
    }


    @PutMapping("/transfer/{userId}")
    public ResponseEntity<TransferResponseDto> transferOperation(
            @PathVariable("userId") Long userId,
            @RequestBody TransferRequest transferRequest
            )
    {
        TransferDto transferDto = transferService.createTransfer(
                transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount()
        );

        accountService.transferProccess(transferRequest.getReceiverAccountId(),
                                        transferRequest.getSenderAccountId(),
                                        transferRequest.getAmount());

        return new ResponseEntity<>(
                new TransferResponseDto("Successfully operation!"),
                HttpStatus.OK
            );

    }



}
