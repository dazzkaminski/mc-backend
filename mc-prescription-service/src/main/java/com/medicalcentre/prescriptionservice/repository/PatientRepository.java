package com.medicalcentre.prescriptionservice.repository;
import com.medicalcentre.prescriptionservice.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Override
    List<Patient> findAll();
}
