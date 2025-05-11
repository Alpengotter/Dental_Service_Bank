package com.alpengotter.dental_service_bank.service;

import com.alpengotter.dental_service_bank.domain.dto.HistoryResponseDto;
import com.alpengotter.dental_service_bank.domain.entity.ClinicEntity;
import com.alpengotter.dental_service_bank.domain.entity.HistoryEntity;
import com.alpengotter.dental_service_bank.domain.entity.OrdersEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import com.alpengotter.dental_service_bank.domain.mapper.HistoryMapper;
import com.alpengotter.dental_service_bank.domain.repository.HistoryRepository;
import com.alpengotter.dental_service_bank.domain.repository.UserRepository;
import com.alpengotter.dental_service_bank.handler.ErrorType;
import com.alpengotter.dental_service_bank.handler.exception.LemonBankException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;
    private final HistoryMapper historyMapper;

    @Transactional
    public void addOrderInHistory(OrdersEntity orders) {
        Integer adminId = Integer.parseInt((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        log.debug("Admin id:{}", adminId);
        Optional<UserEntity> admin = userRepository.findByIdAndIsActiveIsTrue(
            adminId);
        if (admin.isEmpty()) {
            throw new LemonBankException(ErrorType.ADMIN_NOT_FOUND);
        }

//        String dateString = orders.getDate();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDate date = LocalDate.parse(dateString, formatter);
//        log.debug("Parse date:{}",date);
        HistoryEntity historyEntity = HistoryEntity.builder()
            .admin(admin.get())
            .user(orders.getEmployee())
            .date(LocalDateTime.now())
            .type("order")
            .comment("Подтверждение заказа")
            .order(orders)
            .currency("lemons")
            .value(-orders.getTotal())
            .build();
        historyRepository.save(historyEntity);
    }

    @Transactional
    public void changeCurrency(UserEntity user, Integer differenceLemons, Integer differenceDiamonds, String comment) {
        Integer adminId = Integer.parseInt((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        log.debug("Admin id:{}", adminId);
        Optional<UserEntity> admin = userRepository.findByIdAndIsActiveIsTrue(
            adminId);
        if (admin.isEmpty()) {
            throw new LemonBankException(ErrorType.ADMIN_NOT_FOUND);
        }
        if (differenceLemons != 0) {
            HistoryEntity historyLemons = HistoryEntity.builder()
                .admin(admin.get())
                .user(user)
                .date(LocalDateTime.now())
                .type("reward")
                .comment(comment)
                .order(null)
                .currency("lemons")
                .value(differenceLemons)
                .build();
            historyRepository.save(historyLemons);
        }

        if (differenceDiamonds != 0) {
            HistoryEntity historyDiamonds = HistoryEntity.builder()
                .admin(admin.get())
                .user(user)
                .date(LocalDateTime.now())
                .type("reward")
                .comment(comment)
                .order(null)
                .currency("diamonds")
                .value(differenceDiamonds)
                .build();
            historyRepository.save(historyDiamonds);
        }

    }

    @Transactional
    public void changeCurrencyClinic(ClinicEntity clinic, Integer differenceLemons, String comment) {
        Integer adminId = Integer.parseInt((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        log.debug("Admin id:{}", adminId);
        Optional<UserEntity> admin = userRepository.findByIdAndIsActiveIsTrue(
            adminId);
        if (admin.isEmpty()) {
            throw new LemonBankException(ErrorType.ADMIN_NOT_FOUND);
        }
        if (differenceLemons != 0) {
            HistoryEntity historyLemons = HistoryEntity.builder()
                .admin(admin.get())
                .date(LocalDateTime.now())
                .type("reward")
                .comment(comment)
                .order(null)
                .currency("lemons")
                .value(differenceLemons)
                .clinic(clinic)
                .build();
            historyRepository.save(historyLemons);
        }
    }

    @Transactional
    public List<HistoryResponseDto> getHistoryByDateAndParam(String dateFromString, String dateToString,
        String searchParameter) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateFrom = LocalDate.parse(dateFromString, formatter);
        LocalDate dateTo = LocalDate.parse(dateToString, formatter);
        LocalDateTime dateTimeFrom = dateFrom.atStartOfDay();
        LocalDateTime dateTimeTo = dateTo.atStartOfDay();
        if (isEnglishSymbols(searchParameter)) {
            List<HistoryEntity> historyEntities = historyRepository.findAllByDateBetweenAndUserEmailContainingOrderByIdDesc(
                dateTimeFrom, dateTimeTo, searchParameter);
            return historyMapper.toHistoryResponseDtoList(historyEntities);
        } else {
            Set<HistoryEntity> historyEntities =
                historyRepository.findAllByDateBetweenAndUserFirstNameContainingOrUserLastNameContainingOrderByIdDesc(
                    dateTimeFrom, dateTimeTo, searchParameter, searchParameter, searchParameter, searchParameter);
//            historyEntities.addAll(historyRepository.findByComment(searchParameter, dateTimeFrom, dateTimeTo));
            return historyMapper.toHistoryResponseDtoList(historyEntities);
        }
    }

    private boolean isEnglishSymbols(String value) {
        return value.matches("^[a-zA-Z0-9.@]+$");
    }

    @Transactional
    public List<HistoryResponseDto> getHistoryClinicById(Integer id) {
        List<HistoryEntity> historyEntities = historyRepository.findAllByClinicIdOrderByIdDesc(id);
        return historyMapper.toHistoryResponseDtoList(historyEntities);
    }

    public List<HistoryResponseDto> getHistoryUsersById(Integer id) {
        List<HistoryEntity> historyEntities = historyRepository.findAllByUserIdOrderByIdDesc(id);
        return historyMapper.toHistoryResponseDtoList(historyEntities);
    }
}
