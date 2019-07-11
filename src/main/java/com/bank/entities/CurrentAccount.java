package com.bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@DiscriminatorValue("currAcc")
public class CurrentAccount extends Account implements Serializable {

    private double accountDiscovery;

    public CurrentAccount() {
    }
    public CurrentAccount(String code, Date creationDate, double balance, double accountDiscovery) {
        super(code, creationDate, balance);
        this.accountDiscovery = accountDiscovery;
    }

    public double getAccountDiscovery() {
        return accountDiscovery;
    }

    public void setAccountDiscovery(double accountDiscovery) {
        this.accountDiscovery = accountDiscovery;
    }

}
