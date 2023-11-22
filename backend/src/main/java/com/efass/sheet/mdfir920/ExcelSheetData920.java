package com.efass.sheet.mdfir920;

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
public class ExcelSheetData920 {
    private String surname;
    private String first_name;
    private String middle_name;
    private LocalDate date_of_birth;
    private String national_id_card_number;
    private String designation;
    private String permanent_home_address;
    private String name;
    private String branch_code;
    private String state_code;
    private String department;
    private LocalDate date_terminated_or_dismissed;
    private String reasons_for_termination;
    private LocalDate date_reinstated;
    private String reason_for_reinstatement;
    private String organization;
    private String address;
    private LocalDate date_from;
    private LocalDate date_to;
}
