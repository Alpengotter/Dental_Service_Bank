package com.alpengotter.dental_service_bank.domain.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnalitiqueSummaryResponseDto {
    private String type;
    private Integer total;
    private List<Integer> totalMounth;
}
