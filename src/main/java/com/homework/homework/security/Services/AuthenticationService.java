package com.homework.homework.security.Services;

import com.homework.homework.dto.LoginUserDto;
import com.homework.homework.dto.RegistroDto;
import com.homework.homework.entities.User;

public interface AuthenticationService {


    User registrar( RegistroDto data);

    User authenticate(LoginUserDto input);

}
