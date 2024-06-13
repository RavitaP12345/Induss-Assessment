package com.example.induss_pay_demo_project.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "User_bank_tbl")
public class BankDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bankDetailId;
    private String bankName;
    private String bankIfsc;
    private String accountNumber;
    @OneToOne
    @JoinColumn(name = "userId")
    private UserDetailsEntity user;

    public Long getBankDetailId() {
        return bankDetailId;
    }

    public void setBankDetailId(Long bankDetailId) {
        this.bankDetailId = bankDetailId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankIfsc() {
        return bankIfsc;
    }

    public void setBankIfsc(String bankIfsc) {
        this.bankIfsc = bankIfsc;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UserDetailsEntity getUser() {
        return user;
    }

    public void setUser(UserDetailsEntity user) {
        this.user = user;
    }
}
