package com.bank.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ACCOUNT", discriminatorType = DiscriminatorType.STRING, length = 7)
public abstract class Account implements Serializable {
    @Id
    private String code;
    private Date creationDate;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "CUST_CODE")
    private Customer customer;
    @OneToMany(mappedBy = "account")
    private Collection<Operation> operations;

    public Account() {
    }

    public Account(String code, Date creationDate, double balance) {
        this.code = code;
        this.creationDate = creationDate;
        this.balance = balance;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
