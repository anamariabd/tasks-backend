package com.homework.homework.security.Services;

import com.homework.homework.dto.LoginUserDto;
import com.homework.homework.dto.RegistroDto;
import com.homework.homework.entities.User;
import com.homework.homework.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public User registrar(RegistroDto data) {

        User user = new User();
                user.setUserName(data.getUsername());
                user.setName(data.getNombre());
                user. setPassword (passwordEncoder.encode(data.getPassword()));

        return userService.createUsuario(user);
    }

    public User authenticate(LoginUserDto input) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userService.findByUsuario(input.getUsername());
    }
}
