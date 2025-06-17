package com.felipearruda.ctrlZ.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO save(@RequestBody StudentDTO student) {
       return studentService.save(student);
    }

    @PutMapping("/{studentId}")
    public StudentDTO update(@PathVariable Long studentId, @RequestBody StudentDTO student) {
        return studentService.update(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }

    @GetMapping("/{studentId}")
    public StudentDTO getById(@PathVariable Long studentId) {
        return studentService.getById(studentId);
    }

    @GetMapping
    public List<StudentDTO> getAll() {
        return studentService.getAll();
    }

}