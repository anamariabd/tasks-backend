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

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;


    private static final Logger log = LoggerFactory.getLogger(UserServiceImp.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUsuario(@RequestBody User usuario) {

        try {

            String aux = bCryptPasswordEncoder.encode(usuario.getPassword());

            usuario.setPassword(aux);
            log.info(aux);
            return userRepository.save(usuario);

        } catch (Exception e) {
            return null;
        }
    }

    public List<User> getAllUsuarios() {
        return userRepository.findAll();

    }

    public User updateUsuario(long id, User usuario) {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) return null;

        String aux = bCryptPasswordEncoder.encode(usuario.getPassword());

        usuario.setPassword(aux);
        User _usuario = user.get();
        _usuario.setName(usuario.getName());
        _usuario.setLastName(usuario.getLastName());
        _usuario.setUserName(usuario.getUserName());

        return userRepository.save(_usuario);


    }

    public User findByUsuario(String usuario) {
     return userRepository.findByUserName(usuario).orElse(null);
    }



    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}