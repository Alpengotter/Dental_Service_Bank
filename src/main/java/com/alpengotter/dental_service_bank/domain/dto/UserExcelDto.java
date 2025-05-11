package com.alpengotter.dental_service_bank.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserExcelDto {
    @ExcelProperty("ФИО")
    @ColumnWidth(30)
    private String name;
    @ExcelProperty("Кол-во зубов")
    @ColumnWidth(15)
    private Integer countLemons;
    @ExcelProperty("Кол-во алмазов")
    @ColumnWidth(15)
    private Integer countDiamonds;

}
