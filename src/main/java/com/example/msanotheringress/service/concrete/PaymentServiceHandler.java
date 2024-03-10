package com.example.msanotheringress.service.concrete;

import com.example.msanotheringress.dao.entity.PaymentEntity;
import com.example.msanotheringress.dao.repository.PaymentRepository;
import com.example.msanotheringress.exception.NotFoundException;
import com.example.msanotheringress.model.request.CreatePaymentRequest;
import com.example.msanotheringress.model.response.PaymentResponse;
import com.example.msanotheringress.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.msanotheringress.mapper.PaymentMapper.PAYMENT_MAPPER;
import static com.example.msanotheringress.model.enums.PaymentStatus.DELETED;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceHandler implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final AsyncService asyncService;


    @Override
    public void createPayment(CreatePaymentRequest request) {
        log.info("ActionLog.createPayment.start request: {}", request);
        paymentRepository.save(PAYMENT_MAPPER.buildPaymentEntity(request));
        log.info("ActionLog.createPayment.success request: {}", request);
    }

    @Override
    public PaymentResponse getPayment(Long id) {
        log.info("ActionLog.createPayment.start request: {}", id);
        var payment = fetchPaymentIfExist(id);
        return PAYMENT_MAPPER.buildPaymentResponse(payment);

    }

    @Override
    public void updatePaymentDescription(Long id, String description) {
        var payment = fetchPaymentIfExist(id);
        payment.setDescription(description);
        paymentRepository.save(payment);

    }

    @Override
    public void deletePayment(Long id) {
        var payment = fetchPaymentIfExist(id);
        payment.setStatus(DELETED);
        paymentRepository.save(payment);
    }

    @Override
    public List<PaymentResponse> getPayments() {
        return paymentRepository.findAll().stream()
                .map(PAYMENT_MAPPER::buildPaymentResponse)
                .collect(toList());
    }

    @Override
    @SneakyThrows
    @Async
    public void test() {
        log.info("Logic Start");
        asyncService.test2();
        log.info("Logic End");
    }

    private PaymentEntity fetchPaymentIfExist(Long id) throws NotFoundException {
        return paymentRepository.findByIdAndStatusNot(id,DELETED)
                .orElseThrow(() -> new NotFoundException("Payment not found!"));
    }

}
