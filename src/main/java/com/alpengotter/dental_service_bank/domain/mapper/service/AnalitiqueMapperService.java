package com.alpengotter.dental_service_bank.domain.mapper.service;

import com.alpengotter.dental_service_bank.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalitiqueMapperService {
    private final UserRepository userRepository;

    @Named("mapType")
    public String mapType(String email) {
        return new String("");
    }

}
