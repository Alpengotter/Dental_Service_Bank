package com.alpengotter.dental_service_bank.domain.dto;

import lombok.Data;

@Data
public class AdminRegisterDto {
    private String email;
    private String password;
    private String role;

}
