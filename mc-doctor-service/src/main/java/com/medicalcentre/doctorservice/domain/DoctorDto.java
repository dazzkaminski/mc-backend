package com.medicalcentre.doctorservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DoctorDto {
    private Integer id;
    private String firstname;
    private String lastname;
}
