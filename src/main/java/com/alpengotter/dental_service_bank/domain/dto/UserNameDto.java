package com.alpengotter.dental_service_bank.domain.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Builder
public class UserNameDto {
    private String firstName;
    private String lastName;
    private String surname;
}
