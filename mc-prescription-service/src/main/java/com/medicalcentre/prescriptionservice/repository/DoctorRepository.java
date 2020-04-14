package com.medicalcentre.prescriptionservice.repository;
import com.medicalcentre.prescriptionservice.domain.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
    @Override
    List<Doctor> findAll();
}
