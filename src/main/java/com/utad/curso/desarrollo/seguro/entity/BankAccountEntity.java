package com.utad.curso.desarrollo.seguro.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bank_account")
    private Long bankAccountId;

    @Column(name = "iban")
    private String iban;

    @Column(name = "balance")
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner")
    private UserEntity owner;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "allowed_bank_accounts", joinColumns = @JoinColumn(name = "id_bank_account"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<UserEntity> allowedUsers;

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(
            Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(
            String iban) {
        this.iban = iban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(
            Double balance) {
        this.balance = balance;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(
            UserEntity owner) {
        this.owner = owner;
    }

    public List<UserEntity> getAllowedUsers() {
        return allowedUsers;
    }

    public void setAllowedUsers(
            List<UserEntity> allowedUsers) {
        this.allowedUsers = allowedUsers;
    }

}
