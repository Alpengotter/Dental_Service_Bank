package com.alpengotter.dental_service_bank.domain.dto;

import lombok.Data;

@Data
public class OrderWebhookDto {
    private String date;
    private String items;
    private String id;
    private String total;
    private String email;
}
