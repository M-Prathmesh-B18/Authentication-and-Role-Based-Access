package com.Questions.Authentication.and.Role_Based.Access.ErrorHandlet;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@Setter
@Getter
@ToString
public class ApiError {
    private LocalDateTime timestamp;
    private String errorMsg;
    private HttpStatus stauscode;

    public ApiError(){
        this.timestamp=LocalDateTime.now();
    }

    public ApiError(String s, HttpStatus httpStatus) {
        this();
        this.errorMsg=s;
        this.stauscode=httpStatus;
    }
}
