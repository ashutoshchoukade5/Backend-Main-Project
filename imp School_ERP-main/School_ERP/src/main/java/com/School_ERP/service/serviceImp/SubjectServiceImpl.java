package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.StudentDto;
import com.School_ERP.dto.SubjectDto;
import com.School_ERP.entity.Student;
import com.School_ERP.entity.Subject;
import com.School_ERP.repository.SubjectRepository;
import com.School_ERP.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<SubjectDto> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public SubjectDto addSubject(SubjectDto subjectDto) {
        Subject subject = convertToEntity(subjectDto);
        subject = subjectRepository.save(subject);
        return convertToDto(subject);
    }

    @Override
    public SubjectDto updateSubject(Long id, SubjectDto subjectDto) {
        Optional<Subject> existingSubjectOpt = subjectRepository.findById(id);
        if (existingSubjectOpt.isPresent()) {
            Subject existingSubject = existingSubjectOpt.get();
            existingSubject.setSubCode(subjectDto.getSubCode());
            existingSubject.setSubName(subjectDto.getSubName());
            existingSubject.setDays(subjectDto.getDays());
            existingSubject.setWeeklyClasses(subjectDto.getWeeklyClasses());
            existingSubject = subjectRepository.save(existingSubject);
            return convertToDto(existingSubject);
        }
        return null; // Or throw an exception
    }

    @Override
    public String deleteSubject(Long id) {
        subjectRepository.deleteById(id);
        return "Subject deleted successfully!";
    }

    @Override
    public SubjectDto getSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id).orElse(null);
        return convertToDto(subject);
    }

    @Override
    public List<StudentDto> getStudentsBySubjectId(Long subjectId) {
        Optional<Subject> subjectOptional = subjectRepository.findById(subjectId);
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();
            Set<Student> students = subject.getStudents();
            ModelMapper modelMapper = new ModelMapper();
            List<StudentDto> studentDtos = students.stream()
                    .map(student -> modelMapper.map(student, StudentDto.class))
                    .collect(Collectors.toList());
            return studentDtos;
        } else {
            return Collections.emptyList();
        }
    }

    private SubjectDto convertToDto(Subject subject) {
        if (subject == null) {
            return null;
        }
        return new SubjectDto(subject.getSubCode(), subject.getSubName(), subject.getDays(), subject.getWeeklyClasses());
    }

    private Subject convertToEntity(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setSubCode(subjectDto.getSubCode());
        subject.setSubName(subjectDto.getSubName());
        subject.setDays(subjectDto.getDays());
        subject.setWeeklyClasses(subjectDto.getWeeklyClasses());
        return subject;
    }
}
