package com.bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@DiscriminatorValue("WitOp")
public class Withdrawal extends Operation implements Serializable {
    public Withdrawal() {
    }

    public Withdrawal(Date operationDate, Amount amount, Account account) {
        super(operationDate, amount, account);
    }
}
