package com.alpengotter.dental_service_bank.domain.dto;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class ActivitiesResponseDto {
    private Integer id;
    private String title;
    private Integer value;
    private String type;
    @Nullable
    private Boolean isActive;
    private String createdBy;
    @Nullable
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
