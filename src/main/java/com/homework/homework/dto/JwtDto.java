package com.homework.homework.dto;

import com.homework.homework.entities.User;
import lombok.Data;

@Data
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private User user;

    public JwtDto(String token, UserDetailsImpl user, String perfil) {
        this.token = token;
        this.user = new User(user.getId(), user.getUsername(), user.getName(), user.getLastName(), user.getPassword());

    }

}
