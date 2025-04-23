package com.felipearruda.ctrlZ.services.teacher;

import com.felipearruda.ctrlZ.services.dto.TeacherRequestDTO;
import com.felipearruda.ctrlZ.services.dto.TeacherResponseDTO;

public interface TeacherService {

    TeacherResponseDTO registerTeacher(TeacherRequestDTO teacherRequestDTO);

    TeacherResponseDTO updateTeacher(Long teacherId, TeacherRequestDTO teacherRequestDTO);
}
