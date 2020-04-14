package com.medicalcentre.appointmentservice.mapper;
import com.medicalcentre.appointmentservice.domain.Appointment;
import com.medicalcentre.appointmentservice.domain.AppointmentDto;
import com.medicalcentre.appointmentservice.domain.Doctor;
import com.medicalcentre.appointmentservice.domain.Patient;
import com.medicalcentre.appointmentservice.service.DoctorService;
import com.medicalcentre.appointmentservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentMapper {

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

    public Appointment mapToAppointment(AppointmentDto appointmentDto) {
        return new Appointment(
                appointmentDto.getId(),
                appointmentDto.getDate(),
                appointmentDto.getTime(),
                appointmentDto.getStatus(),
                getPatient(appointmentDto.getPatientId()),
                getDoctor(appointmentDto.getDoctorId())
        );
    }

    public AppointmentDto mapToAppointmentDto(Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                appointment.getDate(),
                appointment.getTime(),
                appointment.getStatus(),
                appointment.getPatient().getId(),
                appointment.getDoctor().getId()
        );
    }

    public List<AppointmentDto> mapToAppointmentDtoList(List<Appointment> appointments) {
        return appointments.stream()
                .map(appointment -> new AppointmentDto(
                        appointment.getId(),
                        appointment.getDate(),
                        appointment.getTime(),
                        appointment.getStatus(),
                        appointment.getPatient().getId(),
                        appointment.getDoctor().getId()))
                .collect(Collectors.toList());
    }
}
