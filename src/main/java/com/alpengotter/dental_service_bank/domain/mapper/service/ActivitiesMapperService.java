package com.alpengotter.dental_service_bank.domain.mapper.service;

import com.alpengotter.dental_service_bank.domain.entity.ClinicEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserClinicMapEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import com.alpengotter.dental_service_bank.domain.repository.ActivitiesRepository;
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
public class ActivitiesMapperService {
    private final ActivitiesRepository activitiesRepository;

}
