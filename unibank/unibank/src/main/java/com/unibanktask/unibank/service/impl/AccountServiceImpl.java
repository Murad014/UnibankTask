package com.unibanktask.unibank.service.impl;

import com.unibanktask.unibank.dto.AccountDto;
import com.unibanktask.unibank.dto.UserDto;
import com.unibanktask.unibank.entity.Account;
import com.unibanktask.unibank.entity.User;
import com.unibanktask.unibank.exception.ResourceNotFoundException;
import com.unibanktask.unibank.exception.TransferBalanceException;
import com.unibanktask.unibank.repository.AccountRepository;
import com.unibanktask.unibank.repository.UserRepository;
import com.unibanktask.unibank.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AccountServiceImpl(UserRepository userRepository,
                              AccountRepository accountRepository,
                              ModelMapper modelMapper){
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto, Long userId) {
        User userFromDB = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        Account account = dtoToEntity(accountDto);
        account.setUser(userFromDB);
        return entityToDto(accountRepository.save(account));
    }

    @Override
    public List<AccountDto> fetchAllAccountsByUserId(Long userId) {
        User userFromDB = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        return accountRepository.findByUserId(userId)
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    // transferProccess method for increase and decrease the account balance
    @Override
    public void transferProccess(Long receiverAccoundId, Long senderAccountId, BigDecimal amount) {
        Account senderAccount = accountRepository.findById(senderAccountId).orElseThrow(
                () -> new ResourceNotFoundException("Sender Account 01", "pin", senderAccountId)
        );
        Account receiverAccount = accountRepository.findById(receiverAccoundId).orElseThrow(
                () -> new ResourceNotFoundException("Receiver Account 02", "pin", receiverAccoundId)
        );

        int compareResult = senderAccount.getBalance().compareTo(amount);
        if(compareResult < 0)
            throw new TransferBalanceException(senderAccount.getBalance());

        senderAccount.setBalance(senderAccount.getBalance().subtract(amount));
        receiverAccount.setBalance(receiverAccount.getBalance().add(amount));

        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);
    }


    private AccountDto entityToDto(Account account){
        return  modelMapper.map(account, AccountDto.class);
    }

    private Account dtoToEntity(AccountDto accountDto){
        return modelMapper.map(accountDto, Account.class);
    }
}
