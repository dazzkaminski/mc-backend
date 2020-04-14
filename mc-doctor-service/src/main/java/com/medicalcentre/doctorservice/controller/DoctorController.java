package com.medicalcentre.doctorservice.controller;
import com.medicalcentre.doctorservice.mapper.DoctorMapper;
import com.medicalcentre.doctorservice.exceptions.DoctorNotFoundException;
import com.medicalcentre.doctorservice.service.DoctorService;
import com.medicalcentre.doctorservice.domain.Doctor;
import com.medicalcentre.doctorservice.domain.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorMapper doctorMapper;

    @GetMapping(value = "/doctors")
    public List<DoctorDto> getDoctors() {
        return doctorMapper.mapToDoctorDtoList(doctorService.getDoctors());
    }

    @GetMapping(value = "/doctors/{id}")
    public DoctorDto getDoctor(@PathVariable int id) {
        try {
            return doctorMapper.mapToDoctorDto(doctorService.getDoctor(id)
                    .orElseThrow(DoctorNotFoundException::new));
        } catch (DoctorNotFoundException e) {
            return null;
        }
    }

    @PostMapping(value = "/doctors", consumes = APPLICATION_JSON_VALUE)
    public DoctorDto createDoctor(@RequestBody DoctorDto doctorDto) {
        Doctor doctor = doctorService.saveOrUpdate(doctorMapper.mapToDoctor(doctorDto));
        return doctorMapper.mapToDoctorDto(doctor);
    }

    @PutMapping(value = "/doctors", consumes = APPLICATION_JSON_VALUE)
    public DoctorDto updateDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorMapper.mapToDoctorDto(
                doctorService.saveOrUpdate(
                        doctorMapper.mapToDoctor(doctorDto)
                ));
    }

    @DeleteMapping(value = "/doctors/{id}")
    public void deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
    }
}
