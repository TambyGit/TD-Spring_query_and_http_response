package com.spring.tdspring_2_et_3.controller;

import com.spring.tdspring_2_et_3.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private static final List<Student> studentList = new ArrayList<Student>();

    @PostMapping("/students")
    public List<String> addStudents (@RequestBody List<Student> student) {
        studentList.addAll(student);
        return studentList.stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .toList();
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(@RequestHeader("Accept") String accetHeader) {
        if ("text/plain".equals(accetHeader)) {
            String name = studentList.stream().map(s -> s.getFirstName() + " " + s.getLastName())
                    .collect(Collectors.joining(", "));
            return ResponseEntity.ok()
                    .body(name);
        }
        else if ("application/json".equals(accetHeader)) {
            return ResponseEntity.ok()
                    .body(studentList);
        }else {
            return ResponseEntity.badRequest()
                    .body("Format non supporté");
        }
    }
}
