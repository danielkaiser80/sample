package com.efass.sheet.mdfir921;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExcelSheetData921 {

    private String surname;
    private String first_name;
    private String middle_name;
    private String designation;
    private String sex;
    private LocalDate date_of_birth;
    private String nationality;
    private String state_of_origin;
    private String passport_number;
    private String national_id_card_number;
    private String branch_name;
    private String branch_code;
    private String state_code;
    private String department;
    private LocalDate date_of_fraud;
    private LocalDate date_discovered;
    private BigDecimal amount_involved;
    private String status;
    private BigDecimal amount_recovered;
    private BigDecimal actual_loss;
    private String type;
    private LocalDate date;
}
