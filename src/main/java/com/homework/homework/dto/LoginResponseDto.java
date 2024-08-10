package com.homework.homework.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class LoginResponseDto {

    private String token;
    private long expiresIn;
}
