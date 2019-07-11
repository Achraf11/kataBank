package com.bank;


import com.bank.entities.Account;
import com.bank.entities.CurrentAccount;
import com.bank.services.AccountService;
import com.bank.services.OperationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class AcountServiceTest {

    private AccountService accountService;
    private OperationService operationService;
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Test
    void testDepositAccount() {
        CurrentAccount account = new CurrentAccount("3769987", new Date() , 500,  0 );
        accountService.depositInAccount("769987", 50);
        assertThat(Double.compare(account.getBalance(), 550)==0);
        assertThat(Double.compare(account.getBalance(), 650)!=0);
    }

    @Test
    void testWithDrawalt() {
        CurrentAccount account = new CurrentAccount("3769987", new Date() , 500,  0 );
        accountService.withdraw("769987", 10);
        assertThat(Double.compare(account.getBalance(), 490)==0);
        assertThat(Double.compare(account.getBalance(), 510)==0);
    }
}
