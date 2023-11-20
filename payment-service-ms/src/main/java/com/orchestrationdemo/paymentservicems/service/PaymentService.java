package com.orchestrationdemo.paymentservicems.service;

import com.orchestrationdemo.paymentservicems.model.PaymentRequest;
import com.orchestrationdemo.paymentservicems.model.PaymentResponse;

public interface PaymentService {
    PaymentResponse makePayment(PaymentRequest paymentRequest);
}
