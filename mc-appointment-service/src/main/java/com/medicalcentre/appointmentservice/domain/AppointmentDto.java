package com.medicalcentre.appointmentservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AppointmentDto {
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private Integer patientId;
    private Integer doctorId;
}
