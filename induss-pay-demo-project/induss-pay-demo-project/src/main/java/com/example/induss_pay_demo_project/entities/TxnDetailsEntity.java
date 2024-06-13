package com.example.induss_pay_demo_project.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "User_txn_tbl")
public class TxnDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long txnId;
    private String service;
    private Double amount;
    private Double gst;
    private Double commission;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserDetailsEntity user;

    public Long getTxnId() {
        return txnId;
    }

    public void setTxnId(Long txnId) {
        this.txnId = txnId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }



    public UserDetailsEntity getUser() {
        return user;
    }

    public void setUser(UserDetailsEntity user) {
        this.user = user;
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

