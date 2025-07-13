package com.alpengotter.dental_service_bank.service;

import com.alpengotter.dental_service_bank.domain.dto.ActivitiesResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.OrderResponseDto;
import com.alpengotter.dental_service_bank.domain.entity.ActivitiesEntity;
import com.alpengotter.dental_service_bank.domain.mapper.ActivitiesMapper;
import com.alpengotter.dental_service_bank.domain.repository.ActivitiesRepository;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivitiesService {
    private final ActivitiesMapper activitiesMapper;
    private final ActivitiesRepository activitiesRepository;

    @Transactional
    public List<ActivitiesResponseDto> getAllActiveNominations(Pageable pageable) {
        List<ActivitiesEntity> activeNominations = activitiesRepository.findAllByIsActiveIsTrue()
            .stream()
            .sorted(Comparator.comparing(ActivitiesEntity::getTitle))
            .toList();
        return activitiesMapper.toActivitiesResponseDtoList(activeNominations);
    }

}
