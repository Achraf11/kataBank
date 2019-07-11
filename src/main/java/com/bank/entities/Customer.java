package com.bank.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Long code;
    private String CustommerNom;
    private String SecurityPhone;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Collection<Account> accounts;

    public Customer() {
    }

    public Customer(String code, String custommerNom, String securityPhone) {
        this.code = code;
        CustommerNom = custommerNom;
        SecurityPhone = securityPhone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustommerNom() {
        return CustommerNom;
    }

    public void setCustommerNom(String custommerNom) {
        CustommerNom = custommerNom;
    }

    public String getSecurityPhone() {
        return SecurityPhone;
    }

    public void setSecurityPhone(String securityPhone) {
        SecurityPhone = securityPhone;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
}
