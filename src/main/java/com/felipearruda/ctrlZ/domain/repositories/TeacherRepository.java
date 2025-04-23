package com.felipearruda.ctrlZ.domain.repositories;

import com.felipearruda.ctrlZ.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
