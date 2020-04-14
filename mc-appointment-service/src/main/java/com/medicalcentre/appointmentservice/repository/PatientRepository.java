package com.medicalcentre.appointmentservice.repository;
import com.medicalcentre.appointmentservice.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Override
    List<Patient> findAll();
}
