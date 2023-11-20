package com.orchestrationdemo.paymentservicems.model;

import com.orchestrationdemo.paymentservicems.model.constant.PaymentStatus;
import com.orchestrationdemo.paymentservicems.model.constant.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private String orderId;
    private String userId;
    private Double amount;
    private PaymentStatus status;
    private PaymentType paymentType;
}
