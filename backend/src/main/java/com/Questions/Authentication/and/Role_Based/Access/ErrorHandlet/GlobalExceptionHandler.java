package com.Questions.Authentication.and.Role_Based.Access.ErrorHandlet;

import io.jsonwebtoken.JwtException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUsernameNotFoundException(UsernameNotFoundException ex){
        ApiError error=new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error,error.getStauscode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> UnknownException(Exception e){
        ApiError error=new ApiError("server Error"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error,error.getStauscode());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadCredentialsException ex){
        ApiError error=new ApiError("Bad Creadentials "+ex.getMessage(),HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(error,error.getStauscode());
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handleJwtException(JwtException ex){
        ApiError error=new ApiError("Invalid Jwt Token "+ex.getMessage(),HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(error,error.getStauscode());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException ex){
        ApiError error=new ApiError("Authentication Field "+ex.getMessage(),HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(error,error.getStauscode());
    }


}
