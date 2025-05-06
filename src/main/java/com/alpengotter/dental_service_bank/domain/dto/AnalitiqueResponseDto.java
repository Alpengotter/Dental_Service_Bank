package com.alpengotter.dental_service_bank.domain.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AnalitiqueResponseDto {
    private LocalDateTime date;
    private String type;
    private Integer count;
    private String currency;
}
