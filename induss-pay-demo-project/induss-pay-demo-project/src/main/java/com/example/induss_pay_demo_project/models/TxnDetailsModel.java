package com.example.induss_pay_demo_project.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TxnDetailsModel {
    private Long userId;
    private Long txnId;
    private String customerName;
    @NotBlank(message = "Service must not be blank.")
    @NotNull(message = "Service must not be null.")
    private String service;
    @NotNull(message = "Amount must not be null.")
    private Double amount;
    @NotNull(message = "GST must not be null.")
    private Double gst;
    @NotNull(message = "Commission must not be null.")
    private Double commission;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTxnId() {
        return txnId;
    }

    public void setTxnId(Long txnId) {
        this.txnId = txnId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getGst() {
        return gst;
    }

    public void setGst(Double gst) {
        this.gst = gst;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }
}
