package com.medicalcentre.patientservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String email;
    private String mobile;
    private String address;
    private String nhsnumber;
}
