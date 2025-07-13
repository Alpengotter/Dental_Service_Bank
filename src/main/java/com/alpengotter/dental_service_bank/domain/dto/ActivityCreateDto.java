package com.alpengotter.dental_service_bank.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Builder
public class ActivityCreateDto {

    private String title;
    private Integer value;
    private String type;
    @Nullable
    private Boolean isActive;
}
