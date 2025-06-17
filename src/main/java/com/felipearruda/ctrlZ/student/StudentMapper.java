package com.felipearruda.ctrlZ.student;

import com.felipearruda.ctrlZ.common.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper extends AbstractMapper<Student, StudentDTO> {

    @Override
    public Student toEntity(StudentDTO dto) {
        Student entity = newEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setGender(dto.getGender());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    @Override
    public StudentDTO toDto(Student entity) {
        StudentDTO dto = newDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setBirthDate(entity.getBirthDate());
        dto.setGender(entity.getGender());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    @Override
    public Student newEntity() {
        return new Student();
    }

    @Override
    public StudentDTO newDto() {
        return new StudentDTO();
    }
}
