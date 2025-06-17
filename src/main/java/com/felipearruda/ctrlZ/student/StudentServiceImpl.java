package com.felipearruda.ctrlZ.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentServiceImpl(StudentRepository repository,  StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StudentDTO save(StudentDTO student) {
        Student entity = mapper.toEntity(student);

        Student studentSaved = repository.save(entity);

        return mapper.toDto(studentSaved);
    }

    @Override
    public StudentDTO getById(Long studentId) {
        Student student = getEntityById(studentId);

        return mapper.toDto(student);
    }

    @Override
    public StudentDTO update(Long studentId, StudentDTO student) {
        getEntityById(studentId);

        Student entity = mapper.toEntity(student);
        entity.setId(studentId);
        Student studentSaved = repository.save(entity);

        return mapper.toDto(studentSaved);
    }

    @Override
    public void delete(Long studentId) {
        getEntityById(studentId);

        repository.deleteById(studentId);
    }

    @Override
    public List<StudentDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    private Student getEntityById(Long studentId) {
        return repository
                .findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

}
