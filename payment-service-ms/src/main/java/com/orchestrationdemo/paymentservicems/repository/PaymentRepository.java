package com.orchestrationdemo.paymentservicems.repository;

import com.orchestrationdemo.paymentservicems.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
