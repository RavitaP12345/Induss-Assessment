package com.example.induss_pay_demo_project.repositories;

import com.example.induss_pay_demo_project.entities.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Long> {
    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    UserDetailsEntity findByUserId(Long userId);
}
