package com.alpengotter.dental_service_bank.controller;

import com.alpengotter.dental_service_bank.domain.dto.ClinicBaseDto;
import com.alpengotter.dental_service_bank.domain.dto.ClinicCurrencyUpdateDto;
import com.alpengotter.dental_service_bank.domain.dto.ClinicResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.StatResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.UserBaseDto;
import com.alpengotter.dental_service_bank.domain.dto.UserCurrencyMultipleUpdateDto;
import com.alpengotter.dental_service_bank.domain.dto.UserCurrencyUpdateDto;
import com.alpengotter.dental_service_bank.domain.dto.UserResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.UserStatusMultipleUpdateDto;
import com.alpengotter.dental_service_bank.domain.dto.UserStatusUpdateDto;
import com.alpengotter.dental_service_bank.service.ClinicService;
import com.alpengotter.dental_service_bank.service.UserService;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
@RequestMapping("/api/v1/clinics")
@RequiredArgsConstructor
public class ClinicController {

    private final ClinicService clinicService;

    @PostMapping("")
    public ClinicResponseDto postNewUser(@RequestBody ClinicBaseDto userBaseDto) {
        return clinicService.postNewClinic(userBaseDto);
    }

    @GetMapping("/{id}")
    public ClinicResponseDto getClinicById(@PathVariable("id") Integer id) {
        return clinicService.getUserById(id);
    }

    @GetMapping("/find-by-name")
    public List<ClinicResponseDto> getClinicByName(
        @RequestParam(required = false) String name,
        @PageableDefault(sort = "name", direction = Sort.Direction.ASC, size = Integer.MAX_VALUE) Pageable pageable) {
        return clinicService.getClinicByName(name, pageable);
    }

    @PutMapping ("/currency/{id}")
    public ClinicBaseDto updateClinicCurrencyById(@PathVariable("id") Integer id, @RequestBody
    ClinicCurrencyUpdateDto currencyUpdateDto) {
        return clinicService.updateClinicCurrency(id, currencyUpdateDto);
    }

    @GetMapping("/get-all-stat")
    public StatResponseDto getAllStatistic() {
        return clinicService.getAllStatistic();
    }

}
