package com.medicalcentre.prescriptionservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PrescriptionDto {
    private Integer id;
    private String prescription;
    private LocalDate date;
    private LocalTime time;
    private Integer patientId;
    private Integer doctorId;
}

