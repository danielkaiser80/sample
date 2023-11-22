package com.efass.sheet.mdfir1600;

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
public class ExcelSheetData1600 {
    public BigDecimal loan_or_facilities_type;
    public BigDecimal aggregate_amt_principal;
    public BigDecimal aggregate_amt_accrued_interest;
    public BigDecimal aggregate_amt_total_outstanding;
}
