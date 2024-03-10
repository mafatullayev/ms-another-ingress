package com.example.msanotheringress.controller;

import com.example.msanotheringress.model.response.PaymentResponse;
import com.example.msanotheringress.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("internal/v1/payments")
@RequiredArgsConstructor
public class InternalController {
    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public PaymentResponse getPayment(@PathVariable Long id){
        return paymentService.getPayment(id);
    }
}