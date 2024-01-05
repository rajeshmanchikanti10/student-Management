package com.example.demo.Resources;

import com.example.demo.enums.ErrorCode;
import com.example.demo.exceptions.StudentException;
import com.example.demo.models.Student;
import com.example.demo.response.StudentResponse;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.ResponseUtil;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentResource {
    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(path = "/{email}")
    public @ResponseBody StudentResponse<Student> student(@PathVariable("email") String email) {
        return studentService.getStudent(email)
                .map(ResponseUtil::toResponse)
                .orElseThrow(() -> new StudentException(ErrorCode.NOT_FOUND, "Student Not Found"));
    }

    @PostMapping(produces = "application/json")
    private StudentResponse<Student> createStudent(@RequestBody Student student) {
        return studentService.registerNewStudent(student)
                .map(ResponseUtil::toResponse)
                .orElseThrow(() -> new StudentException(ErrorCode.CREATION_ERROR, "Creation Error"));
    }

    @PutMapping
    private StudentResponse<Student> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student)
                .map(ResponseUtil::toResponse)
                .orElseThrow(() -> new StudentException(ErrorCode.UPDATION_ERROR, "Student Updation Error"));

    }

    @GetMapping("/")
    private StudentResponse<List<Student>> getAllStudent() {
        return ResponseUtil.toResponse(studentService.getAllStudents());
    }
}
