package com.homework.homework.controllers;

import com.homework.homework.entities.User;
import com.homework.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/usuario")
    public ResponseEntity<?> createUsuario(@RequestBody User usuario) {
        try {
            return userService.createUsuario(usuario);
        }catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/usuario")
    public List<User> getAllUsuarios() {
        return userService.getAllUsuarios();
    }

    @GetMapping("/usuario/{user}")
    public User getUsuarioByUsuario(@PathVariable("user") String usuario) throws Exception {

        return userService.findByUsuario(usuario);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable("id") long id, @RequestBody User usuario) {
        try {

            return userService.updateUsuario(id, usuario);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
