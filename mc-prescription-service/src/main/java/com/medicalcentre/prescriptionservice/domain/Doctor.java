package com.medicalcentre.prescriptionservice.domain;
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

    @OneToMany(targetEntity = Prescription.class, mappedBy = "doctor")
    private List<Prescription> prescriptions;
}
