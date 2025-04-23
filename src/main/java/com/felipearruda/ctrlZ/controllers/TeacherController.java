package com.felipearruda.ctrlZ.controllers;

import com.felipearruda.ctrlZ.services.dto.TeacherRequestDTO;
import com.felipearruda.ctrlZ.services.dto.TeacherResponseDTO;
import com.felipearruda.ctrlZ.services.teacher.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TeacherResponseDTO registerTeacher(@RequestBody TeacherRequestDTO requestDTO) {
        return teacherService.registerTeacher(requestDTO);
    }

    @PutMapping("/{teacherId}")
    public TeacherResponseDTO updateTeacher(@PathVariable Long teacherId, @RequestBody TeacherRequestDTO requestDTO) {
        return teacherService.updateTeacher(teacherId, requestDTO);
    }
    
}
