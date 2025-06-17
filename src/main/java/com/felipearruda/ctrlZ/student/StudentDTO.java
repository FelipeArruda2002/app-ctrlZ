package com.felipearruda.ctrlZ.student;

import com.felipearruda.ctrlZ.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO  {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private Gender gender;

    private String password;

}
