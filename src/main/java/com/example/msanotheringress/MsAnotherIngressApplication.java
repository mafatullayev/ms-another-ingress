package com.example.msanotheringress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MsAnotherIngressApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAnotherIngressApplication.class, args);
    }

}
