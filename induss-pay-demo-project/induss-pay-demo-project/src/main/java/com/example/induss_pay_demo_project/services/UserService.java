package com.example.induss_pay_demo_project.services;

import com.example.induss_pay_demo_project.entities.BankDetailsEntity;
import com.example.induss_pay_demo_project.entities.UserDetailsEntity;
import com.example.induss_pay_demo_project.models.UserDetailsModel;
import com.example.induss_pay_demo_project.repositories.UserDetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Transactional
    public ResponseEntity<?> saveUserDetailsWithBankDetails(UserDetailsModel userDetailsModel) {
        try{
            UserDetailsEntity userDetails = new UserDetailsEntity();
            userDetails.setFirstName(userDetailsModel.getFirstName());
            userDetails.setLastName(userDetailsModel.getLastName());
            userDetails.setPhone(userDetailsModel.getPhone());
            userDetails.setEmail(userDetailsModel.getEmail());
            BankDetailsEntity bankDetails = new BankDetailsEntity();
            bankDetails.setBankIfsc(userDetailsModel.getBankDetail().getBankIfsc());
            bankDetails.setBankName(userDetailsModel.getBankDetail().getBankName());
            bankDetails.setAccountNumber(userDetailsModel.getBankDetail().getAccountNumber());
            bankDetails.setUser(userDetails);
            userDetails.setBankDetails(bankDetails);
            userDetailsRepository.save(userDetails);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong.", HttpStatus.OK);

        }

    }
}
