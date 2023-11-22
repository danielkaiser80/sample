package com.efass.sheet.mdfir1301;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExcelSheetData1301 {
    public String serial_no;
    public String customer_name;
    public String customer_code;
    public BigDecimal total_credit;
    public BigDecimal  principal_payment_due_and_unpaid;
    public BigDecimal accrued_interest_unpaid;
    public BigDecimal total_impaired_credits ;
    public BigDecimal impairment ;
    public String remarks;
}
