package com.medicalcentre.prescriptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PrescriptionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrescriptionServiceApplication.class, args);
    }

}
