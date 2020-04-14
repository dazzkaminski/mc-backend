package com.medicalcentre.appointmentservice.repository;
import com.medicalcentre.appointmentservice.domain.Appointment;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    @Override
    List<Appointment> findAll();
}
