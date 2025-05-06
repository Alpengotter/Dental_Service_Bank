package com.alpengotter.dental_service_bank.controller;

import com.alpengotter.dental_service_bank.domain.dto.HistoryResponseDto;
import com.alpengotter.dental_service_bank.service.HistoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/history")
//@CrossOrigin(origins = {"https://bankoflemons.ru", "https://store.zarplata.ru", "https://uat.bankoflemons.ru"})
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping("/find-by-date-and-param")
    public List<HistoryResponseDto> getOrderById(@RequestParam("dateFrom") String dateFrom,
                                         @RequestParam("dateTo") String dateTo,
                                         @RequestParam("searchParameter") String searchParameter) {
        return historyService.getHistoryByDateAndParam(dateFrom, dateTo, searchParameter);
    }

    @GetMapping("/find-by-id")
    public List<HistoryResponseDto> getOrderById(@RequestParam("id") Integer id) {
        return historyService.getHistoryById(id);
    }


}
