package com.alpengotter.dental_service_bank.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequestDto {
    private String email;
    private String password;
}
