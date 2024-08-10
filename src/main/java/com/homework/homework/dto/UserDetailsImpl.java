package com.homework.homework.dto;

import com.homework.homework.entities.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserDetailsImpl implements UserDetails {


    private Integer id;

    private String lastName;
    private String name;
    private String password;
    private String userName;

    public UserDetailsImpl(Integer id, String name, String userName, String lastName, String password) {
        this.name = name;
        this.userName = userName;
        this.id = id;
        this.password = password;
        this.lastName = lastName;
    }


    public static UserDetailsImpl build(User user) {

        return new UserDetailsImpl(user.getId(), user.getName(), user.getUserName(), user.getLastName(), user.getPassword());
    }


    public String getName() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
