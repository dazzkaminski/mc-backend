package com.medicalcentre.appointmentservice.service;
import com.medicalcentre.appointmentservice.domain.Doctor;
import com.medicalcentre.appointmentservice.repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    public static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    public DoctorRepository doctorRepository;

    public Doctor saveOrUpdate(Doctor doctor) {
        LOGGER.info("Saving/updating a doctor");
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctor(int id) {
        LOGGER.info("Getting a doctor: " + id);
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctors() {
        LOGGER.info("Getting all doctors");
        return doctorRepository.findAll();
    }

    public void deleteDoctor(int id) {
        LOGGER.info("Delete a doctor: " + id);
        doctorRepository.deleteById(id);
    }
}
