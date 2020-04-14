package com.medicalcentre.patientservice.controller;
import com.medicalcentre.patientservice.domain.Patient;
import com.medicalcentre.patientservice.domain.PatientDto;
import com.medicalcentre.patientservice.exceptions.PatientNotFoundException;
import com.medicalcentre.patientservice.mapper.PatientMapper;
import com.medicalcentre.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/patients")
    public List<PatientDto> getPatients() {
        return patientMapper.mapToPatientDtoList(patientService.getPatients());
    }

    @GetMapping(value = "/patients/{id}")
    public PatientDto getPatient(@PathVariable int id) {
        try {
            return patientMapper.mapToPatientDto(patientService.getPatient(id)
                    .orElseThrow(PatientNotFoundException::new));
        } catch (PatientNotFoundException e) {
            return null;
        }
    }

    @PostMapping(value = "/patients", consumes = APPLICATION_JSON_VALUE)
    public PatientDto createPatient(@RequestBody PatientDto patientDto) {

        Patient patient = patientService.saverOrUpdate(
                patientMapper.mapToPatient(patientDto));

        restTemplate.postForObject("http://mc-mail-service/welcomeEmail", patient, PatientDto.class);

        return patientMapper.mapToPatientDto(patient);
    }

    @PutMapping(value = "/patients", consumes = APPLICATION_JSON_VALUE)
    public PatientDto updatePatient(@RequestBody PatientDto patientDto) {
        return patientMapper.mapToPatientDto(
                patientService.saverOrUpdate(patientMapper.mapToPatient(patientDto)));
    }

    @DeleteMapping(value = "/patients/{id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
    }
}
