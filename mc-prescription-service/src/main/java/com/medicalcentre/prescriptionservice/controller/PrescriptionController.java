package com.medicalcentre.prescriptionservice.controller;
import com.medicalcentre.prescriptionservice.domain.Prescription;
import com.medicalcentre.prescriptionservice.domain.PrescriptionDto;
import com.medicalcentre.prescriptionservice.exceptions.PrescriptionNotFoundException;
import com.medicalcentre.prescriptionservice.mapper.PrescriptionMapper;
import com.medicalcentre.prescriptionservice.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private PrescriptionMapper prescriptionMapper;

    @GetMapping(value = "/prescriptions")
    public List<PrescriptionDto> getPrescriptions() {
        return prescriptionMapper.mapToPrescriptionDtoList(
                prescriptionService.getPrescriptions());
    }

    @GetMapping(value = "/prescriptions/{id}")
    public PrescriptionDto getPrescription(@PathVariable int id) {
        try {
            return prescriptionMapper.mapToPrescriptionDto(
                    prescriptionService.getPrescription(id)
                            .orElseThrow(PrescriptionNotFoundException::new));
        } catch (PrescriptionNotFoundException e) {
            return null;
        }
    }

    @PostMapping(value = "/prescriptions", consumes = APPLICATION_JSON_VALUE)
    public PrescriptionDto createPrescription(@RequestBody PrescriptionDto prescriptionDto) {
        Prescription prescription = prescriptionService.saveOrUpdate(
                prescriptionMapper.mapToPrescription(prescriptionDto));
        return prescriptionMapper.mapToPrescriptionDto(prescription);
    }

    @PutMapping(value = "/prescriptions", consumes = APPLICATION_JSON_VALUE)
    public PrescriptionDto updatePrescription(@RequestBody PrescriptionDto prescriptionDto) {
        return prescriptionMapper.mapToPrescriptionDto(
                prescriptionService.saveOrUpdate(
                        prescriptionMapper.mapToPrescription(prescriptionDto)));
    }

    @DeleteMapping(value = "/prescriptions/{id}")
    public void deletePrescription(@PathVariable int id) {
        prescriptionService.deletePrescription(id);
    }
}
