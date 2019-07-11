package com.bank.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP", discriminatorType = DiscriminatorType.STRING, length = 5)
public abstract class Operation implements Serializable {
@Id @GeneratedValue
    private long numberOperation ;
    private Date operationDate;
    private double amount;
    @ManyToOne
    @JoinColumn(name= "ACCNT_CDE")
    private Account account;

    public Operation() {
    }

    public Operation(Date operationDate, double amount, Account account) {
        this.operationDate = operationDate;
        this.amount = amount;
        this.account = account;
    }

    public long getNumberOperation() {
        return numberOperation;
    }

    public void setNumberOperation(long numberOperation) {
        this.numberOperation = numberOperation;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
