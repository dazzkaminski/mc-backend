package com.medicalcentre.appointmentservice.controller;
import com.medicalcentre.appointmentservice.mapper.AppointmentMapper;
import com.medicalcentre.appointmentservice.exceptions.AppointmentNotFoundException;
import com.medicalcentre.appointmentservice.service.AppointmentService;
import com.medicalcentre.appointmentservice.domain.Appointment;
import com.medicalcentre.appointmentservice.domain.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(value = "/appointments")
    public List<AppointmentDto> getAppointments() {
        return appointmentMapper.mapToAppointmentDtoList(appointmentService.getAppointments());
    }

    @GetMapping(value = "/appointments/{id}")
    public AppointmentDto getAppointments(@PathVariable int id) {
        try {
            return appointmentMapper.mapToAppointmentDto(
                    appointmentService.getAppointment(id)
                            .orElseThrow(AppointmentNotFoundException::new));
        } catch (AppointmentNotFoundException e) {
            return null;
        }
    }

    @PostMapping(value = "/appointments", consumes = APPLICATION_JSON_VALUE)
    public AppointmentDto createBooking(@RequestBody AppointmentDto appointmentDto) {
        Appointment appointment = appointmentService.saveOrUpdate(appointmentMapper.mapToAppointment(appointmentDto));
        return appointmentMapper.mapToAppointmentDto(appointment);
    }

    @PutMapping(value = "/appointments", consumes = APPLICATION_JSON_VALUE)
    public AppointmentDto updateBooking(@RequestBody AppointmentDto appointmentDto) {
        return appointmentMapper.mapToAppointmentDto(
                appointmentService.saveOrUpdate(
                        appointmentMapper.mapToAppointment(appointmentDto)));
    }

    @DeleteMapping(value = "/appointments/{id}")
    public void deleteBooking(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
    }
}
