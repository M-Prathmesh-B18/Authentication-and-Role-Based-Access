package com.Questions.Authentication.and.Role_Based.Access.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@NotBlank
@ToString
public class SignInRequest {

    private String email;


    private String password;
}
