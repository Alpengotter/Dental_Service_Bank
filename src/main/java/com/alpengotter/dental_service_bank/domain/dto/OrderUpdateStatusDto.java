package com.alpengotter.dental_service_bank.domain.dto;

import lombok.Data;

@Data
public class OrderUpdateStatusDto {
    private String status;
    private Integer id;
}
