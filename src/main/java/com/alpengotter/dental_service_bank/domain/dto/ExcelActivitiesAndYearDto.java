package com.alpengotter.dental_service_bank.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExcelActivitiesAndYearDto {
    private Integer activitiesId;
    private Integer year;
}
