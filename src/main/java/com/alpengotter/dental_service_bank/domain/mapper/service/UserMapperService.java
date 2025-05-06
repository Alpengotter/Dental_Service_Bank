package com.alpengotter.dental_service_bank.domain.mapper.service;

import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapperService {

    @Named("mapFullName")
    public String mapFullName(UserEntity userEntity) {
        StringBuilder result = new StringBuilder();
        if (Objects.nonNull(userEntity.getLastName())) {
            result.append(userEntity.getLastName());
            result.append(" ");
        }
        if (Objects.nonNull(userEntity.getFirstName())) {
            result.append(userEntity.getFirstName());
        }
        return result.toString();
    }

}
