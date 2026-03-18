package com.spring.tdspring_2_et_3.controller;

import com.spring.tdspring_2_et_3.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private static final List<Student> studentList = new ArrayList<Student>();

    @PostMapping("/student")
    public List<String> addStudents (@RequestBody List<Student> student) {
        studentList.addAll(student);
        return studentList.stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .toList();
    }
}
