package com.efass.sheet.mdfir100;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExcelSheet100Data {
    public String code;
    public String description;
    public BigDecimal number_1;
    public BigDecimal value_1;
    public BigDecimal number_2;
    public BigDecimal value_2;
}
