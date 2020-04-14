package com.medicalcentre.patientservice.repository;
import com.medicalcentre.patientservice.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Override
    List<Patient> findAll();
}
