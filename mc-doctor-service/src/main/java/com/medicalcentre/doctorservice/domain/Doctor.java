package com.medicalcentre.doctorservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Doctor {
    @GeneratedValue
    @Id
    private Integer id;
    private String firstname;
    private String lastname;

    @OneToMany(targetEntity = Prescription.class, mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

    @OneToMany(targetEntity = Appointment.class, mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Doctor(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
