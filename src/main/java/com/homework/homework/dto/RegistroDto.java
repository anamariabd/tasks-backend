package com.homework.homework.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistroDto {

    private String username;
    private String nombre;
    private String apellido;
    private String password;
}
