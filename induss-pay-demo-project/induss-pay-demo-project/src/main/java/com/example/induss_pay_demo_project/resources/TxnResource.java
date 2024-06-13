package com.example.induss_pay_demo_project.resources;

import com.example.induss_pay_demo_project.entities.TxnDetailsEntity;
import com.example.induss_pay_demo_project.models.TxnDetailsModel;
import com.example.induss_pay_demo_project.models.UserDetailsModel;
import com.example.induss_pay_demo_project.services.TxnService;
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
@RequestMapping("/txn")
public class TxnResource {
    @Autowired
    private TxnService txnService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> saveTxnDetails(@PathVariable Long userId, @Valid @RequestBody TxnDetailsModel txnDetailsModel, BindingResult result){
        Map<String, String> errorDetails = new HashMap<>();
        if(result.hasErrors()){
            for(FieldError error : result.getFieldErrors()){
                errorDetails.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }else {
            if(txnDetailsModel.getAmount()>0){
                return txnService.saveTxnDetails(txnDetailsModel, userId);
            }else return new ResponseEntity<>("Amount must not be less than 0", HttpStatus.BAD_REQUEST);
        }


    }
    @PostMapping("/get/details")
    public List<TxnDetailsModel> getUserTxnDetailsByUserId(@RequestBody List<Long> userIds){
        return txnService.getUserTxnDetailsByUserId(userIds);
    }
    @GetMapping("/amount/{initial_range}/{final_range}")
    public List<UserDetailsModel> getUserDetailsWithBankAndTxn(@RequestParam("userId") Long userId, @PathVariable Double initial_range, @PathVariable Double final_range){
        return txnService.getUserDetailsWithBankAndTxn(userId, initial_range, final_range);
    }
    @GetMapping("/sort/amount")
    public List<TxnDetailsModel> getTxnDetailsBySortedFormat(){
        return txnService.getTxnDetailsBySortedFormat();
    }
}
