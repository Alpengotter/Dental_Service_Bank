package com.alpengotter.dental_service_bank.domain.mapper;


import com.alpengotter.dental_service_bank.domain.dto.AnalitiqueResponseDto;
import com.alpengotter.dental_service_bank.domain.dto.AnalitiqueSummaryResponseDto;
import com.alpengotter.dental_service_bank.domain.entity.AnalitiqueEntity;
import com.alpengotter.dental_service_bank.domain.entity.HistoryEntity;
import com.alpengotter.dental_service_bank.domain.mapper.service.AnalitiqueMapperService;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = AnalitiqueMapperService.class
)
public interface AnalitiqueMapper {
    AnalitiqueResponseDto toAnalitiqueResponseDto(AnalitiqueEntity analitiqueEntity);

    List<AnalitiqueResponseDto> toAnalitiqueResponseDtoList(List<AnalitiqueEntity> analitiqueEntityList);

    @Mapping(target = "type", source = "analitiqueEntity.type", qualifiedByName = "mapType")
    AnalitiqueSummaryResponseDto toAnalitiqueSummaryResponseDto(AnalitiqueEntity analitiqueEntity);
    List<AnalitiqueSummaryResponseDto> toAnalitiqueSummaryResponseDtoList(List<AnalitiqueEntity> analitiqueEntityList);

    @Mapping(target = "count", source = "historyEntity.value")
    @Mapping(target = "id", ignore = true)
    AnalitiqueEntity toAnalitiqueEntity(HistoryEntity historyEntity);

    List<AnalitiqueEntity> toAnalitiqueEntityList(List<HistoryEntity> historyEntityList);

}
