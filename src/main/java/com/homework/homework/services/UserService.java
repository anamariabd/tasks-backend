package com.homework.homework.services;


import com.homework.homework.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User createUsuario(User user);

    List<User> getAllUsuarios();

    User updateUsuario(long id, User user);

    User findById(long id);

    boolean delete(long id);

    User findByUsuario(String username) ;


}
