package com.homework.homework.services;

import com.homework.homework.entities.User;
import com.homework.homework.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> createUsuario(@RequestBody User usuario) {

        try {

            String aux = bCryptPasswordEncoder.encode(usuario.getPassword());

            usuario.setPassword(aux);
            log.info(aux);
            User _usuario = userRepository.save(usuario);
            return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<User> getAllUsuarios() {
        return userRepository.findAll();

    }

    public ResponseEntity<?> updateUsuario(@PathVariable("id") long id, @RequestBody User usuario) {

        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {

            String aux = bCryptPasswordEncoder.encode(usuario.getPassword());

            usuario.setPassword(aux);
            User _usuario = user.get();
            _usuario.setName(usuario.getName());
            _usuario.setLastName(usuario.getLastName());
            _usuario.setUserName(usuario.getUserName());

            User _user = userRepository.save(_usuario);

            return new ResponseEntity<>(_user, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public User findByUsuario(String usuario) throws Exception{


        Optional<User> us = userRepository.findByUserName(usuario);
        if (us.isPresent() ) {
            return us.get();
        }else {
            throw new Exception("usuario no encontrado");
        }

    }
}