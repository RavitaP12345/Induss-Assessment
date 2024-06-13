package com.example.induss_pay_demo_project.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BankDetailModel {
    private Long userId;
    @NotNull(message = "Bank name must not be null.")
    @NotBlank(message = "Bank name must not be blank.")
    private String bankName;
    @NotNull(message = "IFSC code must not be null.")
    @NotBlank(message = "IFSC code must not be blank.")
    private String bankIfsc;
    @NotNull(message = "Account number must not be null.")
    @NotBlank(message = "Account number must not be blank.")
    private String accountNumber;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
