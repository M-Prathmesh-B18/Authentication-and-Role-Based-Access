package com.Questions.Authentication.and.Role_Based.Access.security;

import com.Questions.Authentication.and.Role_Based.Access.dto.SignInRequest;
import com.Questions.Authentication.and.Role_Based.Access.dto.SignInResponse;
import com.Questions.Authentication.and.Role_Based.Access.dto.SignUpRequest;
import com.Questions.Authentication.and.Role_Based.Access.entity.User;
import com.Questions.Authentication.and.Role_Based.Access.entity.types.Roles;
import com.Questions.Authentication.and.Role_Based.Access.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final HandlerExceptionResolver handlerExceptionResolver;

    public String SignUp(SignUpRequest signUpRequest){
               User userExist= userRepo.findByEmail(signUpRequest.getEmail()).orElseThrow(()->new UsernameNotFoundException("Username Not found ") );
               if(userExist!=null) throw new RuntimeException("User Already exists");

        if (signUpRequest.getRole() == null || signUpRequest.getRole().isEmpty()) {
            throw new RuntimeException("Role is required");
        }

               User user =new User();
               user.setEmail(signUpRequest.getEmail());
               user.setName(signUpRequest.getName());
               user.setRole(Roles.valueOf(signUpRequest.getRole().toUpperCase()));
               user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
               userRepo.save(user);

               return "done";
    }

    public SignInResponse SignIn(SignInRequest signInRequest){
        Authentication authentication = authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(
                            signInRequest.getEmail(),
                            signInRequest.getPassword()
                    ));

            User user = (User) authentication.getPrincipal();
            String token = authUtil.generateAccessToken(user);

        return new SignInResponse(token, user.getUid());
    }


}
