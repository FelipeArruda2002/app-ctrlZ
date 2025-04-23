package com.felipearruda.ctrlZ.mappers.teacher;

import com.felipearruda.ctrlZ.domain.model.Teacher;
import com.felipearruda.ctrlZ.services.dto.TeacherRequestDTO;
import com.felipearruda.ctrlZ.services.dto.TeacherResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public Teacher toEntity(TeacherRequestDTO dto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(dto.firstName());
        teacher.setLastName(dto.lastName());
        teacher.setEmail(dto.email());
        teacher.setPassword(dto.password());
        return teacher;
    }

    public Teacher updateEntity(TeacherRequestDTO dto, Teacher teacher) {
        teacher.setFirstName(dto.firstName());
        teacher.setLastName(dto.lastName());
        teacher.setEmail(dto.email());
        teacher.setPassword(dto.password());
        return teacher;
    }

    public TeacherResponseDTO toResponseDTO(Teacher teacher) {
        return new TeacherResponseDTO(teacher.getFirstName(), teacher.getLastName(), teacher.getEmail());
    }

}
