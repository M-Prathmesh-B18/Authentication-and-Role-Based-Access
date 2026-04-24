package com.Questions.Authentication.and.Role_Based.Access.controller;

import com.Questions.Authentication.and.Role_Based.Access.dto.SignInRequest;
import com.Questions.Authentication.and.Role_Based.Access.dto.SignInResponse;
import com.Questions.Authentication.and.Role_Based.Access.dto.SignUpRequest;
import com.Questions.Authentication.and.Role_Based.Access.security.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> SignUp(@RequestBody SignUpRequest signUpRequest ){
         return  ResponseEntity.ok(authService.SignUp(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> SignIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authService.SignIn(signInRequest));
    }


}
