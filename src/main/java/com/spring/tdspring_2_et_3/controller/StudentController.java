package com.spring.tdspring_2_et_3.controller;

import com.spring.tdspring_2_et_3.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private static final List<Student> studentList = new ArrayList<Student>();

    @PostMapping("/students")
    public ResponseEntity <List<Student>> createStudent(@RequestBody List<Student> student) {
        try{
            studentList.addAll(student);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentList);

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(studentList);
        }
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
