package com.Questions.Authentication.and.Role_Based.Access.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/home")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("Hello User");
    }
}
