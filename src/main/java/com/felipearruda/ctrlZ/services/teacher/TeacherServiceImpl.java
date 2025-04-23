package com.felipearruda.ctrlZ.services.teacher;

import com.felipearruda.ctrlZ.domain.model.Teacher;
import com.felipearruda.ctrlZ.domain.repositories.TeacherRepository;
import com.felipearruda.ctrlZ.exceptions.TeacherNotFoundException;
import com.felipearruda.ctrlZ.mappers.teacher.TeacherMapper;
import com.felipearruda.ctrlZ.services.dto.TeacherRequestDTO;
import com.felipearruda.ctrlZ.services.dto.TeacherResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public TeacherResponseDTO registerTeacher(TeacherRequestDTO teacherRequestDTO) {
        Teacher teacher = teacherMapper.toEntity(teacherRequestDTO);

        Teacher savedTeacher = teacherRepository.save(teacher);

        return teacherMapper.toResponseDTO(savedTeacher);
    }

    @Override
    public TeacherResponseDTO updateTeacher(Long teacherId, TeacherRequestDTO teacherRequestDTO) {
        Teacher teacher = teacherRepository
                .findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException(teacherId));

        teacherMapper.updateEntity(teacherRequestDTO, teacher);

        Teacher updatedTeacher = teacherRepository.save(teacher);

        return teacherMapper.toResponseDTO(updatedTeacher);
    }

}
