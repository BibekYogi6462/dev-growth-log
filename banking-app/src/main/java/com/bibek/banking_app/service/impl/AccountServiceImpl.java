package com.bibek.banking_app.service.impl;

import com.bibek.banking_app.dto.AccountDto;
import com.bibek.banking_app.entity.Account;
import com.bibek.banking_app.mapper.AccountMapper;
import com.bibek.banking_app.repository.AccountRepository;
import com.bibek.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

  private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto createAccount(AccountDto accountDto) {
       Account account  = AccountMapper.mapToAccount(accountDto);
       Account savedAccount = accountRepository.save(account);
         AccountDto savedAccountDto = AccountMapper.mapToAccountDto(savedAccount);
        return savedAccountDto;
    }

    @Override
    public AccountDto getAccountById(Long id) {
            Account account = accountRepository.findById(id).orElse(null);
            return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
            Account account = accountRepository.findById(id).orElse(null);
            if(account != null) {
                double total = account.getBalance() + amount;
                account.setBalance(total);
                Account updatedAccount = accountRepository.save(account);
                return AccountMapper.mapToAccountDto(updatedAccount);
            }
        return null;
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElse(null);
        if(account != null) {
            double total = account.getBalance() - amount;
            account.setBalance(total);
            Account updatedAccount = accountRepository.save(account);
            return AccountMapper.mapToAccountDto(updatedAccount);
        }
        return null;
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
         List<AccountDto> accountDtos = accounts.stream()
                 .map(AccountMapper::mapToAccountDto)
                 .toList();
        return List.of();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            accountRepository.delete(account);
        }
    }

}
