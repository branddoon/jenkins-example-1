package com.jenkins.example.jenkins_example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class PrintController {

    @PostMapping("/print")
    public ResponseEntity<?> print(){
        return new ResponseEntity<>("Printed 200!", HttpStatus.OK);
    }
}
