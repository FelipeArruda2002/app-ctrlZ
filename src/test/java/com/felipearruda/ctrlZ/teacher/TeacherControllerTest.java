package com.felipearruda.ctrlZ.teacher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipearruda.ctrlZ.controllers.TeacherController;
import com.felipearruda.ctrlZ.exceptions.TeacherNotFoundException;
import com.felipearruda.ctrlZ.services.dto.TeacherRequestDTO;
import com.felipearruda.ctrlZ.services.dto.TeacherResponseDTO;
import com.felipearruda.ctrlZ.services.teacher.TeacherService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeacherController.class)
public class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockitoBean
    private TeacherService teacherService;
    private TeacherRequestDTO teacherRequestDTO;
    private TeacherResponseDTO teacherResponseDTO;

    @BeforeEach
    void createTeacher() {
        teacherRequestDTO = new TeacherRequestDTO("Felipe", "Souza", "felipe@gmail.com", "1234");
        teacherResponseDTO = new TeacherResponseDTO("Felipe", "Souza", "felipe@gmail.com");
    }

    @Test
    void registerTeacher_givenValidTeacher_shouldReturnSavedTeacher() throws Exception {
        when(teacherService.registerTeacher(any(TeacherRequestDTO.class)))
                .thenReturn(teacherResponseDTO);

        ResultActions response = mockMvc.perform(post("/teacher")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(teacherRequestDTO))
        );

        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", Matchers.is(teacherRequestDTO.firstName())))
                .andExpect(jsonPath("$.lastName", Matchers.is(teacherRequestDTO.lastName())))
                .andExpect(jsonPath("$.email", Matchers.is(teacherRequestDTO.email())));

    }

    @Test
    void updateTeacher_givenExistingTeacher_shouldReturnUpdatedTeacher() throws Exception {
        TeacherResponseDTO teacherAux = new TeacherResponseDTO("Felipe", "Arruda", "arruda@gmail.com");
        TeacherRequestDTO teacherRequestAux = new TeacherRequestDTO("Felipe", "Arruda", "arruda@gmail.com", "1234");

        when(teacherService.updateTeacher(any(Long.class), any(TeacherRequestDTO.class)))
                .thenReturn(teacherAux);

        ResultActions response = mockMvc.perform(put("/teacher/{teacherId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(teacherRequestAux))
        );

        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName", Matchers.is(teacherAux.lastName())))
                .andExpect(jsonPath("$.email", Matchers.is(teacherAux.email())));
    }


    @Test
    void updateTeacher_GivenTeacherIdInvalid_shouldThrowException() throws Exception {
        TeacherRequestDTO teacherRequestAux = new TeacherRequestDTO("Felipe", "Arruda", "arruda@gmail.com", "1234");

        when(teacherService.updateTeacher(any(Long.class), any(TeacherRequestDTO.class)))
                .thenThrow(new TeacherNotFoundException(1L));

        ResultActions response = mockMvc.perform(put("/teacher/{teacherId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(teacherRequestAux)));

        response.andDo(print())
                .andExpect(status().isNotFound());
    }

}
