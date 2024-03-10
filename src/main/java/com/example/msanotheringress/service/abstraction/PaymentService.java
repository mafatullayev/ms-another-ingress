package com.example.msanotheringress.service.abstraction;

import com.example.msanotheringress.model.request.CreatePaymentRequest;
import com.example.msanotheringress.model.response.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    void createPayment(CreatePaymentRequest request);

    PaymentResponse getPayment(Long id);

    void updatePaymentDescription(Long id, String description);

    void deletePayment(Long id);

    List<PaymentResponse> getPayments();

    void test();
}