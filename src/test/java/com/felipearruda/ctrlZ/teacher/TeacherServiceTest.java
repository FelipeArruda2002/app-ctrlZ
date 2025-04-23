package com.felipearruda.ctrlZ.teacher;

import com.felipearruda.ctrlZ.domain.model.Teacher;
import com.felipearruda.ctrlZ.domain.repositories.TeacherRepository;
import com.felipearruda.ctrlZ.exceptions.TeacherNotFoundException;
import com.felipearruda.ctrlZ.mappers.teacher.TeacherMapper;
import com.felipearruda.ctrlZ.services.dto.TeacherRequestDTO;
import com.felipearruda.ctrlZ.services.dto.TeacherResponseDTO;
import com.felipearruda.ctrlZ.services.teacher.TeacherServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepository;
    @Mock
    private TeacherMapper teacherMapper;
    @InjectMocks
    private TeacherServiceImpl teacherService;
    private TeacherRequestDTO requestDTO;
    private TeacherResponseDTO responseDTO;
    private Teacher teacher;

    @BeforeEach
    void createTeacher() {
        requestDTO = new TeacherRequestDTO("Felipe", "Souza", "felipe@gmail.com", "1234");
        teacher = new Teacher(1L, "Felipe", "Souza", "felipe@gmail.com", "1234");
        responseDTO = new TeacherResponseDTO("Felipe", "Souza", "felipe@gmail.com");
    }

    @Test
    void registerTeacher_givenValidTeacher_shouldReturnSavedTeacher() {
        when(teacherMapper.toEntity(any(TeacherRequestDTO.class))).thenReturn(teacher);
        when(teacherRepository.save(any(Teacher.class))).thenReturn(teacher);
        when(teacherMapper.toResponseDTO(any(Teacher.class))).thenReturn(responseDTO);

        TeacherResponseDTO savedTeacher = teacherService.registerTeacher(requestDTO);

        verify(teacherRepository).save(any(Teacher.class));
        verify(teacherMapper).toEntity(any(TeacherRequestDTO.class));
        verify(teacherMapper).toResponseDTO(any(Teacher.class));

        Assertions.assertEquals(responseDTO, savedTeacher);
    }

    @Test
    void updateTeacher_givenExistingTeacher_shouldReturnUpdatedTeacher() {
        TeacherRequestDTO teacherAux = new TeacherRequestDTO("Felipe", "Souza", "souza@gmail.com", "****");
        TeacherResponseDTO teacherResponse = new TeacherResponseDTO("Felipe", "Souza", "souza@gmail.com");

        when(teacherRepository.findById(any(Long.class))).thenReturn(Optional.of(teacher));
        when(teacherMapper.updateEntity(any(TeacherRequestDTO.class), any(Teacher.class))).thenReturn(teacher);
        when(teacherRepository.save(any(Teacher.class))).thenReturn(teacher);
        when(teacherMapper.toResponseDTO(any(Teacher.class))).thenReturn(teacherResponse);

        TeacherResponseDTO updatedTeacher = teacherService.updateTeacher(1L, teacherAux);

        verify(teacherRepository).save(any(Teacher.class));
        verify(teacherMapper).updateEntity(any(TeacherRequestDTO.class), any(Teacher.class));
        verify(teacherMapper).toResponseDTO(any(Teacher.class));

        Assertions.assertNotEquals(responseDTO, updatedTeacher);
    }

    @Test
    void updateTeacher_GivenTeacherIdInvalid_shouldThrowException() {
        TeacherRequestDTO teacherAux = new TeacherRequestDTO("Felipe", "Souza", "souza@gmail.com", "****");

        when(teacherRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(TeacherNotFoundException.class, () -> {
            teacherService.updateTeacher(1l, teacherAux);
        });

        verify(teacherRepository, never()).save(any());
    }

}
