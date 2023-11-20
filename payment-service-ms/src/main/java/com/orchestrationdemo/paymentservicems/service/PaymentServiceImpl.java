package com.orchestrationdemo.paymentservicems.service;

import com.orchestrationdemo.paymentservicems.entity.Payment;
import com.orchestrationdemo.paymentservicems.model.PaymentRequest;
import com.orchestrationdemo.paymentservicems.model.PaymentResponse;
import com.orchestrationdemo.paymentservicems.model.constant.PaymentStatus;
import com.orchestrationdemo.paymentservicems.model.constant.PaymentType;
import com.orchestrationdemo.paymentservicems.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.orchestrationdemo.paymentservicems.model.constant.PaymentStatus.PAYMENT_APPROVED;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public PaymentResponse makePayment(PaymentRequest paymentRequest) {

        Payment payment =
                Payment.builder()
                .orderId(paymentRequest.getOrderId())
                .userId(paymentRequest.getUserId())
                .amount(paymentRequest.getAmount())
                .paymentType(String.valueOf(paymentRequest.getPaymentType()))
                .status(String.valueOf(PAYMENT_APPROVED))
                .build();
        paymentRepository.save(payment);

        PaymentResponse paymentResponse =
                PaymentResponse.builder()
                        .orderId(payment.getOrderId())
                        .userId(payment.getUserId())
                        .amount(payment.getAmount())
                        .paymentType(PaymentType.valueOf(payment.getPaymentType()))
                        .status(PaymentStatus.valueOf(payment.getStatus()))
                        .build();
        return paymentResponse;
    }
}
