package com.alpengotter.dental_service_bank.domain.mapper;


import com.alpengotter.dental_service_bank.domain.dto.ActivitiesResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.UserBaseDto;
import com.alpengotter.dental_service_bank.domain.dto.UserExcelDto;
import com.alpengotter.dental_service_bank.domain.dto.UserResponseDto;
import com.alpengotter.dental_service_bank.domain.entity.ActivitiesEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import com.alpengotter.dental_service_bank.domain.mapper.service.ActivitiesMapperService;
import com.alpengotter.dental_service_bank.domain.mapper.service.UserMapperService;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = ActivitiesMapperService.class)
public interface ActivitiesMapper {

    ActivitiesResponseDto toActivitiesResponseDto(ActivitiesEntity entity);
    List<ActivitiesResponseDto> toActivitiesResponseDtoList(List<ActivitiesEntity> entities);

}
