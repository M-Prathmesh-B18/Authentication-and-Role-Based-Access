package com.Questions.Authentication.and.Role_Based.Access.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class SignUpRequest {

    private String email;


    private String password;


    private String name;


    private String role;
}
