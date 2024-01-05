package com.example.demo.services;

import com.example.demo.enums.ErrorCode;
import com.example.demo.exceptions.StudentException;
import com.example.demo.models.Student;
import com.example.demo.student.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ObjectMapperUtils;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Optional<Student> getStudent(String email) {
        return  studentRepository.findStudentByEmail(email);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Optional<Student>  registerNewStudent(Student student){
       Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
       if(studentByEmail.isPresent()){
           throw new StudentException(ErrorCode.CREATION_ERROR,"Student Already Present");
       }
       log.info(String.format("<---inserting {}--->", ObjectMapperUtils.getObjectAsString(student)));
       return Optional.of(studentRepository.save(student));
    }
    @Transactional
    public Optional<Student> updateStudent(Student student) {
        Optional<Student> studentFound = studentRepository.findStudentByEmail(student.getEmail());
        if (!studentFound.isPresent()) {
            throw new StudentException(ErrorCode.UPDATION_ERROR,"Student Doesn't exists");
        }
        studentFound.stream().forEach(student1 -> {
            student1.setName(student.getName());
            student1.setEmail(student.getEmail());
            student1.setDob(student.getDob());
        });
        Student savedStudent = studentFound.orElse(null);
        log.info(String.format("<---updating {}--->",savedStudent.toString()));
        studentRepository.save(savedStudent);
        return Optional.of(savedStudent);

    }
}
