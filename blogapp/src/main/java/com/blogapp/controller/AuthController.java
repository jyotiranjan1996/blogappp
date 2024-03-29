package com.blogapp.controller;

import com.blogapp.exception.EmailUsernameAlreadyExistException;
import com.blogapp.payload.LoginDto;
import com.blogapp.payload.Signup;
import com.blogapp.repository.UserRepository;
import com.blogapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    AuthenticationManager authenticationManager;

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @PostMapping("/sign-up")
    public ResponseEntity<?> createUser(@RequestBody Signup signup) {


        userService.createUser(signup);
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.CREATED);

    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> SignIn(@RequestBody LoginDto loginDto)
    {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>("Sign in successful",HttpStatus.OK);
    }
}






