package com.alpengotter.dental_service_bank.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivitiesExcelDto {
    @ExcelProperty("Название активности")
    @ColumnWidth(70)
    private String title;
    @ExcelProperty("Сумма начислений")
    @ColumnWidth(30)
    private Integer countActivities;


}
