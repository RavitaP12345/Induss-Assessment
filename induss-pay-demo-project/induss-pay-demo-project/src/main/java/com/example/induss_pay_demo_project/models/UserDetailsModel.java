package com.example.induss_pay_demo_project.models;

import jakarta.validation.constraints.*;

import java.util.List;

public class UserDetailsModel {
    private Long userId;
    @NotNull(message = "First name must not be null.")
    @NotBlank(message = "First name must not be blank.")
    @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "First name must be alphanumeric and between 5 to 20 characters.")
    private String firstName;
    @NotNull(message = "Last name must not be null.")
    @NotBlank(message = "Last name must not be blank.")
    @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "Last name must be alphanumeric and between 5 to 20 characters.")
    private String lastName;
    @NotNull(message = "Email must not be null.")
    @NotBlank(message = "Email must not be blank.")
    @Email(message = "Email is incorrect.")
    private String email;
    @NotNull(message = "Phone number must not be null.")
    @NotBlank(message = "Phone number must not be blank.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits.")
    private String phone;
    private BankDetailModel bankDetail;
    private List<TxnDetailsModel> tnxDetails;

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



    public List<TxnDetailsModel> getTnxDetails() {
        return tnxDetails;
    }

    public void setTnxDetails(List<TxnDetailsModel> tnxDetails) {
        this.tnxDetails = tnxDetails;
    }

    public BankDetailModel getBankDetail() {
        return bankDetail;
    }

    public void setBankDetail(BankDetailModel bankDetail) {
        this.bankDetail = bankDetail;
    }
}
