package com.bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@DiscriminatorValue("depOp")
public class Deposit extends Operation implements Serializable {
    public Deposit() {
    }

    public Deposit(Date operationDate, double amount, Account account) {
        super(operationDate, amount, account);
    }
}
