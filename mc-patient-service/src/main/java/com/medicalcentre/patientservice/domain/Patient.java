package com.medicalcentre.patientservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Patient {
    @GeneratedValue
    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String email;
    private String mobile;
    private String address;
    private String nhsnumber;

    @OneToMany(targetEntity = Prescription.class, mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

    @OneToMany(targetEntity = Appointment.class, mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Patient(Integer id, String firstname, String lastname, LocalDate dateOfBirth,
                   String email, String mobile, String address, String nhsnumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.nhsnumber = nhsnumber;
    }
}
