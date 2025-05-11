package com.alpengotter.dental_service_bank.domain.mapper;


import com.alpengotter.dental_service_bank.domain.dto.UserBaseDto;
import com.alpengotter.dental_service_bank.domain.dto.UserExcelDto;
import com.alpengotter.dental_service_bank.domain.dto.UserResponseDto;
import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import com.alpengotter.dental_service_bank.domain.mapper.service.UserMapperService;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = UserMapperService.class)
public interface UserMapper {
    @Mapping(target = "clinics", source = "entity.userClinicMap", qualifiedByName = "mapUserClinicMap")
    UserResponseDto toUserResponseDto(UserEntity entity);
    List<UserResponseDto> toListUserResponseDto(Page<UserEntity> entities);
    List<UserResponseDto> toListUserResponseDto(List<UserEntity> entities);
    @Mapping(target = "isActive", source = "userBaseDto.isActive", defaultValue = "true")
    UserEntity toUserEntity(UserBaseDto userBaseDto);

    @Mapping(target = "name", source = "userEntity", qualifiedByName = "mapFullName")
    @Mapping(target = "countLemons", source = "userEntity.lemons")
//    @Mapping(target = "countDiamonds", source = "userEntity.diamonds")
    UserExcelDto toUserExcelDto(UserEntity userEntity);

    List<UserExcelDto> toUserExcelDtoList (List<UserEntity> userEntityList);

}
