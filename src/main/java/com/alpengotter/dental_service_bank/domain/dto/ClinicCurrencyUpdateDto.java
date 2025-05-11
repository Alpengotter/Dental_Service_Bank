package com.alpengotter.dental_service_bank.domain.dto;

import lombok.Data;

@Data
public class ClinicCurrencyUpdateDto {
    private Long currency;
    private String comment;
}
