package com.medicalcentre.prescriptionservice.service;
import com.medicalcentre.prescriptionservice.domain.Patient;
import com.medicalcentre.prescriptionservice.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    public static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    public PatientRepository patientRepository;

    public Patient saverOrUpdate(Patient patient) {
        LOGGER.info("Saving/updating a patient");
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatient(int id) {
        LOGGER.info("Getting a patient: " + id);
        return patientRepository.findById(id);
    }

    public List<Patient> getPatients() {
        LOGGER.info("Getting all patients");
        return patientRepository.findAll();
    }

    public void deletePatient(int id) {
        LOGGER.info("Delete patient: " + id);
        patientRepository.deleteById(id);
    }
}
