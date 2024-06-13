package com.example.induss_pay_demo_project.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "User_tbl")
public class UserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private BankDetailsEntity bankDetails;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TxnDetailsEntity> tnxDetails;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BankDetailsEntity getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetailsEntity bankDetails) {
        this.bankDetails = bankDetails;
    }

    public List<TxnDetailsEntity> getTnxDetails() {
        return tnxDetails;
    }

    public void setTnxDetails(List<TxnDetailsEntity> tnxDetails) {
        this.tnxDetails = tnxDetails;
    }
}
