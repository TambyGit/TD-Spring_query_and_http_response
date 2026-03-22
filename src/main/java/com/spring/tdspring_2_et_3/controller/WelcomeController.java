package com.spring.tdspring_2_et_3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String name) {
        if (name == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Parameter name is empty or null");
        }else {
            return ResponseEntity.ok().
                    body("Welcome " + name);
        }
    }
}
