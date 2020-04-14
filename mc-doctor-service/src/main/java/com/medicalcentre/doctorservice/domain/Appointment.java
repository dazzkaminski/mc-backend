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
public class Appointment {
    @GeneratedValue
    @Id
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private String status;

    @ManyToOne
    private Doctor doctor;
}
