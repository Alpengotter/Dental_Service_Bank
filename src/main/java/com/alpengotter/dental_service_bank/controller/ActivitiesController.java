package com.alpengotter.dental_service_bank.controller;

import com.alpengotter.dental_service_bank.domain.dto.ActivitiesResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.ActivityCreateDto;
import com.alpengotter.dental_service_bank.domain.dto.UserBaseDto;
import com.alpengotter.dental_service_bank.domain.dto.UserResponseDto;
import com.alpengotter.dental_service_bank.service.ActivitiesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
public class ActivitiesController {

    private final ActivitiesService activitiesService;

    @GetMapping("")
    public List<ActivitiesResponseDto> getActiveActivities(Pageable pageable) {
        return activitiesService.getAllActiveActivities(pageable);
    }

    @GetMapping("/get-all-activities")
    public List<ActivitiesResponseDto> getAllActivities(Pageable pageable) {
        return activitiesService.getAllActivities(pageable);
    }

    @PostMapping("")
    public ActivitiesResponseDto createNewActivity(@RequestBody ActivityCreateDto createDto) {
        return activitiesService.createNewActivity(createDto);
    }

    @PutMapping("/{id}")
    public ActivitiesResponseDto updateActivity(@PathVariable("id") Integer id, @RequestBody
    ActivityCreateDto userBaseDto) {
        return activitiesService.updateActivity(id, userBaseDto);
    }

}
