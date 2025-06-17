package com.felipearruda.ctrlZ.student;

import java.util.List;

public interface StudentService {

    StudentDTO save(StudentDTO student);

    StudentDTO getById(Long studentId);

    StudentDTO update(Long studentId, StudentDTO student);

    void delete(Long studentId);

    List<StudentDTO> getAll();
}
