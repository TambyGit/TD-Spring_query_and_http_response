package com.spring.tdspring_2_et_3.validator;

import com.spring.tdspring_2_et_3.Student;
import com.spring.tdspring_2_et_3.exeption.BadRequestExeption;

import java.util.List;

public class StudentValidator {

    public void validate(List<Student> students){
        for(Student student:students){
            if (student.getReference() == null || student.getReference().isEmpty()){
                throw new BadRequestExeption("Reference cannot be empty");
            }
            if (student.getFirstName() == null || student.getFirstName().isEmpty()){
                throw new BadRequestExeption("First name cannot be empty");
            }
            if  (student.getLastName() == null || student.getLastName().isEmpty()){
                throw new BadRequestExeption("Last name cannot be empty");
            }
        }
    }
}
