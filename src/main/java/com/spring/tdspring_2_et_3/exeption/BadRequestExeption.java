package com.spring.tdspring_2_et_3.exeption;

public class BadRequestExeption extends RuntimeException {
    public BadRequestExeption(String message) {
        super(message);
    }
}
