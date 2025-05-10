package com.alpengotter.dental_service_bank.domain.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

@Data
public class UserResponseDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String surname;
    private String email;
    private Integer lemons;
    private Integer diamonds;
    private String userRole;
    @Nullable
    private String jobTitle;
    @Nullable
    private Boolean isActive;
    @Nullable
    private List<String> clinics;
}
