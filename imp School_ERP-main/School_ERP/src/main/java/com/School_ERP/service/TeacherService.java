package com.School_ERP.service;

import com.School_ERP.dto.TeacherDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    ResponseEntity<?> saveTeacher(TeacherDto teacherDto);
    List<TeacherDto> findAll();
    Optional<TeacherDto> findById(int id);
    void deleteById(int id);
    void updateById(int id, TeacherDto teacherDto);
}
