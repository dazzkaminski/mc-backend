package com.medicalcentre.mailservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    private Integer id;
    private String firstname;
    private String lastname;
}
