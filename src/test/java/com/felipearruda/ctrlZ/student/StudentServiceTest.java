package com.felipearruda.ctrlZ.student;

import com.felipearruda.ctrlZ.domain.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository repository;
    @Mock
    StudentMapper mapper;
    @InjectMocks
    StudentServiceImpl service;

    Student student;
    StudentDTO studentDTO;

    @BeforeEach
    void createStudent() {
        student = new Student(null,
                "Felipe", "Arruda",
                "felipe@gmail.com", LocalDate.of(2002, 1, 5),
                Gender.MALE, "12345678");

        studentDTO = new StudentDTO(null, "Felipe", "Arruda",
                "felipe@gmail.com", LocalDate.of(2002, 1, 5),
                Gender.MALE, "12345678");
    }

    @Test
    void save_WhenStudentProvided_ReturnsSavedStudent() {
        when(mapper.toEntity(any(StudentDTO.class))).thenReturn(student);
        when(repository.save(any(Student.class))).thenReturn(student);
        when(mapper.toDto(any(Student.class))).thenReturn(studentDTO);

        StudentDTO studentSaved = service.save(studentDTO);

        verify(mapper, times(1)).toEntity(any(StudentDTO.class));
        verify(repository, times(1)).save(any(Student.class));
        verify(mapper, times(1)).toDto(any(Student.class));

        assertNotNull(studentSaved);
        assertEquals("Felipe", studentSaved.getFirstName());
        assertEquals("felipe@gmail.com", studentSaved.getEmail());
    }
}
