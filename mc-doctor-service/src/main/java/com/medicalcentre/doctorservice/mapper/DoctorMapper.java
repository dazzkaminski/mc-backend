package com.medicalcentre.doctorservice.mapper;
import com.medicalcentre.doctorservice.repository.DoctorRepository;
import com.medicalcentre.doctorservice.domain.Doctor;
import com.medicalcentre.doctorservice.domain.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {

    @Autowired
    public DoctorRepository doctorRepository;

    public Doctor mapToDoctor(DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getId(),
                doctorDto.getFirstname(),
                doctorDto.getLastname()
        );
    }

    public DoctorDto mapToDoctorDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getId(),
                doctor.getFirstname(),
                doctor.getLastname()
        );
    }

    public List<DoctorDto> mapToDoctorDtoList(List<Doctor> doctors) {
        return doctors.stream()
                .map(doctor -> new DoctorDto(
                        doctor.getId(),
                        doctor.getFirstname(),
                        doctor.getLastname()))
                .collect(Collectors.toList());
    }
}
