package com.homework.homework.controllers;


import com.homework.homework.dto.LoginResponseDto;
import com.homework.homework.dto.LoginUserDto;
import com.homework.homework.dto.RegistroDto;
import com.homework.homework.dto.UserDetailsImpl;
import com.homework.homework.entities.User;
import com.homework.homework.security.Services.AuthenticationService;
import com.homework.homework.security.jwt.JwtEntryPoint;
import com.homework.homework.security.jwt.JwtProvider;
import com.homework.homework.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController {


    private final JwtProvider jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegistroDto registerUserDto) {
        User registeredUser = authenticationService.registrar(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        UserDetailsImpl userDetails = new UserDetailsImpl(authenticatedUser.getId(), authenticatedUser.getName(),
                authenticatedUser.getUserName(), authenticatedUser.getLastName(), authenticatedUser.getPassword());
        String jwtToken = jwtService.generateToken(userDetails);

        LoginResponseDto loginResponse = LoginResponseDto.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();

        return ResponseEntity.ok(loginResponse);
    }
}
