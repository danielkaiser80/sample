package com.efass.sheet.mdfir1700;

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
public class ExcelSheetData1700 {
    public String serial_no;
    public String name;
    public String sector;
    public String  crms_borrower_code;
    public String rc_or_br_or_sr_no;
    public BigDecimal total;
    public String classified_as_npa;
    public BigDecimal investment;
    public BigDecimal liabilities;
    public BigDecimal total_exposure;
}
