package com.orchestrationdemo.paymentservicems.entity;

import com.orchestrationdemo.paymentservicems.model.constant.PaymentStatus;
import com.orchestrationdemo.paymentservicems.model.constant.PaymentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @Column(name = "ORDER_ID")
    private String orderId;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "PAYMENT_STATUS")
    private String status;
    @Column(name = "PAYMENT_TYPE")
    private String paymentType;
}
