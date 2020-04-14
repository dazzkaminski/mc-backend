package com.medicalcentre.appointmentservice.repository;
import com.medicalcentre.appointmentservice.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
    @Override
    List<Doctor> findAll();
}
