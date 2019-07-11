package com.bank.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.math.BigDecimal;

public class Prestation implements Serializable {
    public Integer getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(Integer idPrestation) {
        this.idPrestation = idPrestation;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public BigDecimal getLibeleCompte() {
        return libeleCompte;
    }

    public void setLibeleCompte(BigDecimal libeleCompte) {
        this.libeleCompte = libeleCompte;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPrestation;

    @Version
    private Integer solde;

    private String numeroCompte;
    private BigDecimal libeleCompte;


}
