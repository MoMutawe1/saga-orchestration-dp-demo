package com.orchestrationdemo.paymentservicems.controller;

import com.orchestrationdemo.paymentservicems.model.PaymentRequest;
import com.orchestrationdemo.paymentservicems.model.PaymentResponse;
import com.orchestrationdemo.paymentservicems.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/makePayment")
    public ResponseEntity<PaymentResponse> paymentService(@RequestBody PaymentRequest paymentRequest){

        PaymentResponse paymentResponse = paymentService.makePayment(paymentRequest);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }
}
