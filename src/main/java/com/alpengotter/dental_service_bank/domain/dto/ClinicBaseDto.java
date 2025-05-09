package com.alpengotter.dental_service_bank.domain.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class ClinicBaseDto {
    private String name;
    @Nullable
    private Long currency;
}
