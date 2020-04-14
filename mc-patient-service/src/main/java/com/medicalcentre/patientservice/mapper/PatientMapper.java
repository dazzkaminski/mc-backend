package com.medicalcentre.patientservice.mapper;
import com.medicalcentre.patientservice.domain.Patient;
import com.medicalcentre.patientservice.domain.PatientDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {

    public Patient mapToPatient(PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getFirstname(),
                patientDto.getLastname(),
                patientDto.getDateOfBirth(),
                patientDto.getEmail(),
                patientDto.getMobile(),
                patientDto.getAddress(),
                patientDto.getNhsnumber()
        );
    }

    public PatientDto mapToPatientDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getFirstname(),
                patient.getLastname(),
                patient.getDateOfBirth(),
                patient.getEmail(),
                patient.getMobile(),
                patient.getAddress(),
                patient.getNhsnumber()
        );
    }

    public List<PatientDto> mapToPatientDtoList(List<Patient> patients) {
        return patients.stream()
                .map(patient -> new PatientDto(
                        patient.getId(),
                        patient.getFirstname(),
                        patient.getLastname(),
                        patient.getDateOfBirth(),
                        patient.getEmail(),
                        patient.getMobile(),
                        patient.getAddress(),
                        patient.getNhsnumber()
                )).collect(Collectors.toList());
    }
}
