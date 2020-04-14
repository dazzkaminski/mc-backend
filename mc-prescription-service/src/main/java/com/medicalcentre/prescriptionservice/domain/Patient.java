package com.medicalcentre.prescriptionservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    @OneToMany(targetEntity = Prescription.class, mappedBy = "patient")
    private List<Prescription> prescriptions;
}
