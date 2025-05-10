package com.alpengotter.dental_service_bank.domain.mapper.service;

import com.alpengotter.dental_service_bank.domain.entity.ClinicEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserClinicMapEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import com.alpengotter.dental_service_bank.domain.repository.ClinicRepository;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapperService {
    private final ClinicRepository clinicRepository;

    @Named("mapFullName")
    public String mapFullName(UserEntity userEntity) {
        StringBuilder result = new StringBuilder();
        if (Objects.nonNull(userEntity.getLastName())) {
            result.append(userEntity.getLastName());
            result.append(" ");
        }
        if (Objects.nonNull(userEntity.getFirstName())) {
            result.append(userEntity.getFirstName());
        }
        return result.toString();
    }

    @Named("mapUserClinicMap")
    public List<String> mapUserClinicMap(Set<UserClinicMapEntity> userClinicMap) {
        return userClinicMap.stream()
            .map(UserClinicMapEntity::getClinic)
            .map(ClinicEntity::getName)
            .collect(Collectors.toList());
    }

}
