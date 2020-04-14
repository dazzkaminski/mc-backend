package com.medicalcentre.mailservice.scheduled;
import com.medicalcentre.mailservice.domain.Appointment;
import com.medicalcentre.mailservice.domain.Mail;
import com.medicalcentre.mailservice.domain.Patient;
import com.medicalcentre.mailservice.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class AppointmentReminder {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentReminder.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendReminder() {

        Appointment[] appointments =
                restTemplate.getForObject("http://mc-appointment-service/appointments", Appointment[].class);

        Arrays.asList(appointments).stream()
                .filter(a -> a.getDate().equals(LocalDate.now().plusDays(1)))
                .filter(a -> a.getStatus().contains("Pending"))
                .map(a -> restTemplate.getForObject("http://mc-patient-service/patients/"
                        + a.getPatientId(), Patient.class))
                .forEach(a -> emailService.send(
                        new Mail(a.getEmail(),
                        "",
                        "Appointment reminder",
                        "You have an appointment with your doctor tomorrow."))
                );
        }
}
