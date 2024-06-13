package com.example.induss_pay_demo_project.repositories;

import com.example.induss_pay_demo_project.entities.TxnDetailsEntity;
import com.example.induss_pay_demo_project.entities.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TxnDetailsRepository extends JpaRepository<TxnDetailsEntity, Long> {
    List<TxnDetailsEntity> findByUser(UserDetailsEntity userDetails);

    List<TxnDetailsEntity> findAllByOrderByAmountAsc();
}
