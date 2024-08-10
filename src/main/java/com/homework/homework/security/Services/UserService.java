package com.homework.homework.security.Services;


import com.homework.homework.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User updete(User user);

    User findById(Integer id);

    boolean delete(Integer id);

    User findByUserName(String username);

    boolean exitsUserbyUsername(String username);
}
