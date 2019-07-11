package com.bank.services;

import com.bank.entities.Account;

public interface AccountService {

    public Account getAccount(String codeAccount);
    public void depositInAccount(String codeAccount, double amount);
    public void withdraw(String codeAccount, double amount);
}
