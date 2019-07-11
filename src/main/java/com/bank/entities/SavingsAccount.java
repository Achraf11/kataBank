package com.bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@DiscriminatorValue("SavnAcc")
public class SavingsAccount extends Account implements Serializable {
    private double rate;

    public SavingsAccount() {
    }
    public double getRate() {
        return rate;
    }

    public SavingsAccount(String code, Date creationDate, double balance, double rate) {
        super(code, creationDate, balance);
        this.rate = rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
