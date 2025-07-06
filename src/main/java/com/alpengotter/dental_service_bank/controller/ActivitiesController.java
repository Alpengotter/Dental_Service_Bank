package com.alpengotter.dental_service_bank.controller;

import com.alpengotter.dental_service_bank.domain.dto.ActivitiesResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.ClinicBaseDto;
import com.alpengotter.dental_service_bank.domain.dto.ClinicCurrencyUpdateDto;
import com.alpengotter.dental_service_bank.domain.dto.ClinicResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.StatResponseDto;
import com.alpengotter.dental_service_bank.service.ActivitiesService;
import com.alpengotter.dental_service_bank.service.ClinicService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
public class ActivitiesController {

    private final ActivitiesService activitiesService;

    @GetMapping("")
    public List<ActivitiesResponseDto> getActiveActivities(Pageable pageable) {
        return activitiesService.getAllActiveNominations(pageable);
    }

}
