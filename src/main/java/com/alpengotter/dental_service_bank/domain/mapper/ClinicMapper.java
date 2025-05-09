package com.alpengotter.dental_service_bank.domain.mapper;


import com.alpengotter.dental_service_bank.domain.dto.ClinicBaseDto;
import com.alpengotter.dental_service_bank.domain.dto.ClinicResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.UserBaseDto;
import com.alpengotter.dental_service_bank.domain.dto.UserExcelDto;
import com.alpengotter.dental_service_bank.domain.dto.UserResponseDto;
import com.alpengotter.dental_service_bank.domain.entity.ClinicEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import com.alpengotter.dental_service_bank.domain.mapper.service.UserMapperService;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClinicMapper {
    ClinicResponseDto toClinicResponseDto(ClinicEntity entity);
//    List<UserResponseDto> toListUserResponseDto(Page<UserEntity> entities);
    List<ClinicResponseDto> toClinicResponseDtoList(Page<ClinicEntity> entities);
//    @Mapping(target = "isActive", source = "userBaseDto.isActive", defaultValue = "true")
    ClinicEntity toClinicEntity(ClinicBaseDto clinicBaseDto);
//
//    @Mapping(target = "name", source = "userEntity", qualifiedByName = "mapFullName")
//    @Mapping(target = "countLemons", source = "userEntity.lemons")
//    @Mapping(target = "countDiamonds", source = "userEntity.diamonds")
//    UserExcelDto toUserExcelDto(UserEntity userEntity);
//
//    List<UserExcelDto> toUserExcelDtoList (List<UserEntity> userEntityList);

}
