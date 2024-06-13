package com.example.induss_pay_demo_project.repositories;

import com.example.induss_pay_demo_project.entities.BankDetailsEntity;
import com.example.induss_pay_demo_project.entities.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetailsEntity, Long> {
    BankDetailsEntity findByUser(UserDetailsEntity user);
}
