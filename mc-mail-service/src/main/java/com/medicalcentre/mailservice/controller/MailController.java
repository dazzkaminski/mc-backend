package com.medicalcentre.mailservice.controller;
import com.medicalcentre.mailservice.domain.Mail;
import com.medicalcentre.mailservice.domain.Patient;
import com.medicalcentre.mailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/welcomeEmail", consumes = APPLICATION_JSON_VALUE)
    private void sendMail(@RequestBody Patient patient) {

        Mail mail = new Mail(patient.getEmail(),
                "",
                "Welcome to our Medical Centre",
                "Welcome to our Medical Centre"
        );

        Optional.of(patient).ifPresent(p -> emailService.send(mail));
    }
}
