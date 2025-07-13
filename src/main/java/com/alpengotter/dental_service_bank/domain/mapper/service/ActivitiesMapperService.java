package com.alpengotter.dental_service_bank.domain.mapper.service;

import com.alpengotter.dental_service_bank.domain.dto.ExcelActivitiesAndYearDto;
import com.alpengotter.dental_service_bank.domain.entity.ActivitiesEntity;
import com.alpengotter.dental_service_bank.domain.entity.HistoryEntity;
import com.alpengotter.dental_service_bank.domain.repository.ActivitiesRepository;
import com.alpengotter.dental_service_bank.domain.repository.HistoryRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivitiesMapperService {
    private final ActivitiesRepository activitiesRepository;
    private final HistoryRepository historyRepository;

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

}
