package com.medicalcentre.prescriptionservice.service;
import com.medicalcentre.prescriptionservice.domain.Prescription;
import com.medicalcentre.prescriptionservice.repository.PrescriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    public static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionService.class);

    @Autowired
    public PrescriptionRepository prescriptionRepository;

    public Prescription saveOrUpdate(Prescription prescription) {
        LOGGER.info("Saving/updating a prescription");
        return prescriptionRepository.save(prescription);
    }

    public Optional<Prescription> getPrescription(int id) {
        LOGGER.info("Gettting a prescription: " + id);
        return prescriptionRepository.findById(id);
    }

    public List<Prescription> getPrescriptions() {
        LOGGER.info("Getting all prescriptions");
        return prescriptionRepository.findAll();
    }

    public void deletePrescription(int id) {
        LOGGER.info("Delete a a prescription: " + id);
        prescriptionRepository.deleteById(id);
    }
}
