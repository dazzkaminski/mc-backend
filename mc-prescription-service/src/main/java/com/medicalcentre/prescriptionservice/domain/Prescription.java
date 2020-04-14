package com.medicalcentre.prescriptionservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Prescription {
    @GeneratedValue
    @Id
    private Integer id;
    private String prescription;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;
}
