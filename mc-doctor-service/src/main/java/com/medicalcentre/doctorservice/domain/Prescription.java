package com.medicalcentre.doctorservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private Doctor doctor;
}
