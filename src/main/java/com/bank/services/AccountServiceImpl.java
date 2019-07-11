package com.bank.services;


import com.bank.entities.Account;
import com.bank.entities.CurrentAccount;
import com.bank.entities.Deposit;
import com.bank.repositories.AccountRepository;
import com.bank.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setOperationRepository(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public Account getAccount(String codeAccount) {
        Account account = accountRepository.findOne(codeAccount);
        if(account == null) throw new RuntimeException("account not found");
        return account;
    }

    @Override
    public void depositInAccount(String codeAccount, double amount) {
        Account account = getAccount(codeAccount);
        Deposit depo = new Deposit(new Date(), amount, account);
        operationRepository.save(depo);
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        accountRepository.save(account);
    }

    @Override
    public void withdraw(String codeAccount, double amount) {
        Account account = getAccount(codeAccount);
        double accountDiscovery = 0;
        if(account instanceof CurrentAccount)
            accountDiscovery = ((CurrentAccount) account).getAccountDiscovery();
        if(account.getBalance() + accountDiscovery < amount)
            throw new RuntimeException("inssufisient balance");
        Deposit depo = new Deposit(new Date(), amount, account);
        operationRepository.save(depo);
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        accountRepository.save(account);
    }
}
