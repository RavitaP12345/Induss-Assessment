package com.example.induss_pay_demo_project.resources;

import com.example.induss_pay_demo_project.models.TxnDetailsModel;
import com.example.induss_pay_demo_project.models.UserDetailsModel;
import com.example.induss_pay_demo_project.repositories.UserDetailsRepository;
import com.example.induss_pay_demo_project.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> saveUserDetailsWithBankDetails(@Valid @RequestBody UserDetailsModel userDetailsModel, BindingResult result){
        Map<String, String> errorDetails = new HashMap<>();
        if(result.hasErrors()){
            for(FieldError error : result.getFieldErrors()){
                errorDetails.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }else {
            if(userDetailsRepository.existsByEmail(userDetailsModel.getEmail()) || userDetailsRepository.existsByPhone(userDetailsModel.getPhone())){
                return new ResponseEntity<>("Duplicate email or phone.", HttpStatus.BAD_REQUEST);
            }else{
                return userService.saveUserDetailsWithBankDetails(userDetailsModel);
            }
        }

    }

}
