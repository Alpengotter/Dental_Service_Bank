package com.alpengotter.dental_service_bank.service;

import com.alpengotter.dental_service_bank.domain.dto.ActivitiesResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.ActivityCreateDto;
import com.alpengotter.dental_service_bank.domain.dto.OrderResponseDto;
import com.alpengotter.dental_service_bank.domain.entity.ActivitiesEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserClinicMapEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import com.alpengotter.dental_service_bank.domain.mapper.ActivitiesMapper;
import com.alpengotter.dental_service_bank.domain.repository.ActivitiesRepository;
import com.alpengotter.dental_service_bank.domain.repository.UserRepository;
import com.alpengotter.dental_service_bank.handler.ErrorType;
import com.alpengotter.dental_service_bank.handler.exception.LemonBankException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivitiesService {
    private final ActivitiesMapper activitiesMapper;
    private final ActivitiesRepository activitiesRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<ActivitiesResponseDto> getAllActiveActivities(Pageable pageable) {
        List<ActivitiesEntity> activeNominations = activitiesRepository.findAllByIsActiveIsTrue()
            .stream()
            .sorted(Comparator.comparing(ActivitiesEntity::getTitle))
            .toList();
        return activitiesMapper.toActivitiesResponseDtoList(activeNominations);
    }

    @Transactional
    public List<ActivitiesResponseDto> getAllActivities(Pageable pageable) {
        List<ActivitiesEntity> activeNominations = activitiesRepository.findAll()
            .stream()
            .sorted(Comparator.comparing(ActivitiesEntity::getTitle))
            .toList();
        return activitiesMapper.toActivitiesResponseDtoList(activeNominations);
    }

    @Transactional
    public ActivitiesResponseDto createNewActivity(ActivityCreateDto createDto) {
        Optional<ActivitiesEntity> existedActivities = activitiesRepository.findByTitleAndIsActiveIsTrue(createDto.getTitle());
        if (existedActivities.isPresent()) {
            throw new LemonBankException(ErrorType.ACTIVITIES_ALREADY_EXIST);
        }
        ActivitiesEntity activitiesEntity = activitiesMapper.toActivitiesEntity(createDto);
        ActivitiesEntity saved = activitiesRepository.save(activitiesEntity);
        return activitiesMapper.toActivitiesResponseDto(saved);
    }

    public ActivitiesResponseDto updateActivity(Integer id, ActivityCreateDto createDto) {
        ActivitiesEntity activitiesEntity = activitiesRepository.findById(id)
            .orElseThrow(() -> new LemonBankException(ErrorType.ACTIVITIES_NOT_FOUND));
        activitiesMapper.updateActivity(createDto, activitiesEntity, id);
        ActivitiesEntity saved = activitiesRepository.saveAndFlush(activitiesEntity);
        return activitiesMapper.toActivitiesResponseDto(saved);
    }
}
