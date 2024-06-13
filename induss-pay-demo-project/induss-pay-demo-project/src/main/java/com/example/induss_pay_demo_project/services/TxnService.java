package com.example.induss_pay_demo_project.services;

import com.example.induss_pay_demo_project.entities.BankDetailsEntity;
import com.example.induss_pay_demo_project.entities.TxnDetailsEntity;
import com.example.induss_pay_demo_project.entities.UserDetailsEntity;
import com.example.induss_pay_demo_project.models.BankDetailModel;
import com.example.induss_pay_demo_project.models.TxnDetailsModel;
import com.example.induss_pay_demo_project.models.UserDetailsModel;
import com.example.induss_pay_demo_project.repositories.BankDetailsRepository;
import com.example.induss_pay_demo_project.repositories.TxnDetailsRepository;
import com.example.induss_pay_demo_project.repositories.UserDetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TxnService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private TxnDetailsRepository txnDetailsRepository;
    @Autowired
    private BankDetailsRepository bankDetailsRepository;
    @Transactional
    public ResponseEntity<?> saveTxnDetails(TxnDetailsModel txnDetailsModel, Long userId) {
        try{
            UserDetailsEntity userDetails = userDetailsRepository.findByUserId(userId);
            TxnDetailsEntity txnDetailsEntity = new TxnDetailsEntity();
            txnDetailsEntity.setGst(txnDetailsModel.getGst());
            txnDetailsEntity.setService(txnDetailsModel.getService());
            txnDetailsEntity.setCommission(txnDetailsModel.getCommission());
            txnDetailsEntity.setAmount(txnDetailsModel.getAmount());
            txnDetailsEntity.setUser(userDetails);
            txnDetailsRepository.save(txnDetailsEntity);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong.", HttpStatus.BAD_REQUEST);

        }

    }

    public List<TxnDetailsModel> getUserTxnDetailsByUserId(List<Long> userIds) {
        List<TxnDetailsModel> txnDetailsModels = new ArrayList<>();
        try{
            if(!userIds.isEmpty()){
                userIds.forEach(userId ->{
                    UserDetailsEntity userDetails = userDetailsRepository.findByUserId(userId);
                    List<TxnDetailsEntity> txnDetailsEntities = txnDetailsRepository.findByUser(userDetails);
                    List<TxnDetailsModel> txnDetailsModelsV1 = new ArrayList<>();
                    txnDetailsEntities.forEach(txn ->{
                        TxnDetailsModel model = new TxnDetailsModel();
                        model.setUserId(txn.getUser().getUserId());
                        model.setTxnId(txn.getTxnId());
                        model.setCustomerName(txn.getUser().getFirstName()+" "+txn.getUser().getLastName());
                        model.setAmount(txn.getAmount());
                        model.setService(txn.getService());
                        model.setCommission(txn.getCommission());
                        model.setGst(txn.getGst());
                        txnDetailsModelsV1.add(model);
                    });
                    txnDetailsModels.addAll(txnDetailsModelsV1);
                });
            }else {
                List<TxnDetailsEntity> txnDetailsEntities = txnDetailsRepository.findAll();
                txnDetailsEntities.forEach(txn ->{
                    TxnDetailsModel model = new TxnDetailsModel();
                    model.setUserId(txn.getUser().getUserId());
                    model.setTxnId(txn.getTxnId());
                    model.setCustomerName(txn.getUser().getFirstName()+" "+txn.getUser().getLastName());
                    model.setAmount(txn.getAmount());
                    model.setService(txn.getService());
                    model.setCommission(txn.getCommission());
                    model.setGst(txn.getGst());
                    txnDetailsModels.add(model);
                });
        }


        }catch (Exception e){
            System.out.println("e==>"+e);
        }
        return txnDetailsModels;
    }

    public List<UserDetailsModel> getUserDetailsWithBankAndTxn(Long userId, Double initialRange, Double finalRange) {

        List<UserDetailsModel> userDetailsModels = new ArrayList<>();
        try{
            List<UserDetailsEntity> userDetailsEntities = userDetailsRepository.findAll();
            userDetailsEntities.forEach(user->{
                List<TxnDetailsEntity> txnDetailsEntities = txnDetailsRepository.findByUser(user).stream().filter(us -> us.getAmount()>=initialRange && us.getAmount()<=finalRange).toList();
                if(!txnDetailsEntities.isEmpty()){
                    UserDetailsModel userModel = new UserDetailsModel();
                    userModel.setUserId(user.getUserId());
                    userModel.setFirstName(user.getFirstName());
                    userModel.setLastName(user.getLastName());
                    userModel.setEmail(user.getEmail());
                    userModel.setPhone(user.getPhone());
                    BankDetailModel bankDetailModel = new BankDetailModel();
                    BankDetailsEntity bankDetails = bankDetailsRepository.findByUser(user);
                    bankDetailModel.setBankIfsc(bankDetails.getBankIfsc());
                    bankDetailModel.setBankName(bankDetails.getBankName());
                    bankDetailModel.setAccountNumber(bankDetails.getAccountNumber());
                    bankDetailModel.setUserId(bankDetails.getUser().getUserId());
                    userModel.setBankDetail(bankDetailModel);
                    userModel.setTnxDetails(convertEntityToModel(txnDetailsEntities));
                    userDetailsModels.add(userModel);
                }
            });
        }catch (Exception e){
            System.out.println("e==>"+e);
        }
        return userDetailsModels;
    }

    public List<TxnDetailsModel> convertEntityToModel(List<TxnDetailsEntity> txnDetailsEntities){
        List<TxnDetailsModel> txnDetailsModels = new ArrayList<>();
        txnDetailsEntities.forEach(data->{
            TxnDetailsModel txnDetailsModel = new TxnDetailsModel();
            txnDetailsModel.setUserId(data.getUser().getUserId());
            txnDetailsModel.setGst(data.getGst());
            txnDetailsModel.setCommission(data.getCommission());
            txnDetailsModel.setService(data.getService());
            txnDetailsModel.setAmount(data.getAmount());
            txnDetailsModel.setTxnId(data.getTxnId());
            UserDetailsEntity userDetails = userDetailsRepository.findByUserId(data.getUser().getUserId());
            txnDetailsModel.setCustomerName(userDetails.getFirstName()+" "+userDetails.getLastName());
            txnDetailsModels.add(txnDetailsModel);
        });
        return txnDetailsModels;
    }

    public List<TxnDetailsModel> getTxnDetailsBySortedFormat() {
        try{
            List<TxnDetailsEntity> txnDetailsEntities = txnDetailsRepository.findAllByOrderByAmountAsc();
            return convertEntityToModel(txnDetailsEntities);
        }catch (Exception e){
            System.out.println("e====>"+e);
        }
        return new ArrayList<TxnDetailsModel>();
    }
}
