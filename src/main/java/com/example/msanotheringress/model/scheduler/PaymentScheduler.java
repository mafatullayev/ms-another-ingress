package com.example.msanotheringress.model.scheduler;

import com.example.msanotheringress.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentScheduler {
    private final PaymentService paymentService;

    @Async
    @Scheduled(cron = "0/5 * * * * *")
    public void paymentScheduler() {
        log.info("PaymentScheduler start");
        paymentService.test();
        log.info("PaymentScheduler end");
    }
}