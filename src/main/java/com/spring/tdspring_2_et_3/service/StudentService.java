package com.spring.tdspring_2_et_3.service;

import com.spring.tdspring_2_et_3.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final List<Student> studentList = new ArrayList<>();

    public List<Student> saveStudentOnMemory(List<Student> students) {
        studentList.addAll(students);
        return studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

}
