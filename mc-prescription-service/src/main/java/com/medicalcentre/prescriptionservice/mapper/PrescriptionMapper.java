package com.medicalcentre.prescriptionservice.mapper;
import com.medicalcentre.prescriptionservice.domain.Doctor;
import com.medicalcentre.prescriptionservice.domain.Patient;
import com.medicalcentre.prescriptionservice.domain.Prescription;
import com.medicalcentre.prescriptionservice.domain.PrescriptionDto;
import com.medicalcentre.prescriptionservice.service.DoctorService;
import com.medicalcentre.prescriptionservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrescriptionMapper {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    public Patient getPatient(int id) {
        return patientService.getPatient(id).get();
    }

    public Doctor getDoctor(int id) {
        return doctorService.getDoctor(id).get();
    }

    public Prescription mapToPrescription(PrescriptionDto prescriptionDto) {
        return new Prescription(
                prescriptionDto.getId(),
                prescriptionDto.getPrescription(),
                prescriptionDto.getDate(),
                prescriptionDto.getTime(),
                getPatient(prescriptionDto.getPatientId()),
                getDoctor(prescriptionDto.getDoctorId())
        );
    }

    public PrescriptionDto mapToPrescriptionDto(Prescription prescription) {
        return new PrescriptionDto(
                prescription.getId(),
                prescription.getPrescription(),
                prescription.getDate(),
                prescription.getTime(),
                prescription.getPatient().getId(),
                prescription.getDoctor().getId()
        );
    }

    public List<PrescriptionDto> mapToPrescriptionDtoList(List<Prescription> prescriptions) {
        return prescriptions.stream()
                .map(prescription -> new PrescriptionDto(
                        prescription.getId(),
                        prescription.getPrescription(),
                        prescription.getDate(),
                        prescription.getTime(),
                        prescription.getPatient().getId(),
                        prescription.getDoctor().getId()))
                .collect(Collectors.toList());
    }
}
