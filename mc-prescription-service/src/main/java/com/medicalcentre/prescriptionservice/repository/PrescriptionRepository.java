package com.medicalcentre.prescriptionservice.repository;
import com.medicalcentre.prescriptionservice.domain.Prescription;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PrescriptionRepository extends CrudRepository<Prescription, Integer> {
    @Override
    List<Prescription> findAll();
}
