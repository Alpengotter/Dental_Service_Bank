package com.alpengotter.dental_service_bank.domain.dto;

import java.util.List;
import lombok.Data;

@Data
public class UserStatusMultipleUpdateDto {
    private List<Integer> userIds;
    private Boolean isActive;
}
