package com.medicalcentre.appointmentservice.service;
import com.medicalcentre.appointmentservice.domain.Appointment;
import com.medicalcentre.appointmentservice.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    public static final Logger LOGGER = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment saveOrUpdate(Appointment appointment) {
        LOGGER.info("Saving/updating an appointment");
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> getAppointment(int id) {
        LOGGER.info("Getting one appointment: " + id);
        return appointmentRepository.findById(id);
    }

    public List<Appointment> getAppointments() {
        LOGGER.info("Getting all appointments");
        return appointmentRepository.findAll();
    }

    public void deleteAppointment(int id) {
        LOGGER.info("Delete an appointment: " + id);
        appointmentRepository.deleteById(id);
    }
}
