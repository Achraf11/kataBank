package com.bank.controllers;

import com.bank.entities.Account;
import com.bank.entities.Operation;
import com.bank.services.AccountService;
import com.bank.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AccountController {

    private AccountService accountService;
    private OperationService operationService;
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    @Autowired
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }

    /**
     * afficher compte.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAccount", method = RequestMethod.GET)
    public String getAccount(Model model, String accountCode) {
        model.addAttribute("accountCode", accountCode);
        try {
            Account account = accountService.getAccount(accountCode);
            Iterable<Operation> operations = operationService.listOperations(accountCode);
            model.addAttribute("account", account);
        } catch(Exception e) {
            model.addAttribute("exception", e);
        }
        return "account";
    }

    @RequestMapping(value = "/depositMoney", method = RequestMethod.POST)
    public void depositMoney(Model model, String accountCode, double montant) {
        try {
              accountService.depositInAccount(accountCode, montant);
        } catch(Exception e) {
            model.addAttribute("exception", e);
        }
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public void withdraw(Model model, String accountCode, double montant) {
        try {
            accountService.withdraw(accountCode, montant);
        } catch(Exception e) {
            model.addAttribute("exception", e);
        }
    }
}
