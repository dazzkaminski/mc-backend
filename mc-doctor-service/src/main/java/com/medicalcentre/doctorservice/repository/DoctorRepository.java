package com.medicalcentre.doctorservice.repository;
import com.medicalcentre.doctorservice.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
    @Override
    List<Doctor> findAll();
}
