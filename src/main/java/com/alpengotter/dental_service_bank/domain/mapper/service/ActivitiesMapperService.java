package com.alpengotter.dental_service_bank.domain.mapper.service;

import com.alpengotter.dental_service_bank.domain.dto.ActivityCreateDto;
import com.alpengotter.dental_service_bank.domain.dto.ExcelActivitiesAndYearDto;
import com.alpengotter.dental_service_bank.domain.entity.ActivitiesEntity;
import com.alpengotter.dental_service_bank.domain.entity.HistoryEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import com.alpengotter.dental_service_bank.domain.repository.ActivitiesRepository;
import com.alpengotter.dental_service_bank.domain.repository.HistoryRepository;
import com.alpengotter.dental_service_bank.domain.repository.UserRepository;
import com.alpengotter.dental_service_bank.handler.ErrorType;
import com.alpengotter.dental_service_bank.handler.exception.LemonBankException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Named;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivitiesMapperService {
    private final ActivitiesRepository activitiesRepository;
    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;

    @Named("mapCountActivities")
    public Integer mapCountActivities(ExcelActivitiesAndYearDto dto) {
        Integer activitiesId = dto.getActivitiesId();
        Integer year = dto.getYear();
        return historyRepository.findByActivitiesIdAndYear(activitiesId, year).stream()
            .mapToInt(HistoryEntity::getValue)
            .sum();
    }

    @Named("mapActivitiesTitle")
    public String mapActivitiesTitle(ExcelActivitiesAndYearDto dto) {
        return activitiesRepository.findById(dto.getActivitiesId())
            .map(ActivitiesEntity::getTitle)
            .orElse(null);
    }

    @Named("mapActivitiesAdminName")
    public String mapActivitiesAdminName(ActivityCreateDto dto) {
        Integer adminId = Integer.parseInt((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        UserEntity admin = userRepository.findByIdAndIsActiveIsTrue(adminId)
            .orElseThrow(() -> new LemonBankException(ErrorType.ADMIN_NOT_FOUND));
        return StringUtils.trimToEmpty((admin.getLastName() != null ? admin.getLastName() : "")
            + " "
            + (admin.getFirstName() != null ? admin.getFirstName() : "")
            + " "
            + (admin.getSurname() != null ? admin.getSurname() : ""));
    }

}
