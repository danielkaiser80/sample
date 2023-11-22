package com.efass.sheet.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rpt_template", schema = "RPT_TEMPLATE")
public class TabSheet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SERIAL_NUMBER")
    public int serial_number;
    @Column(name = "BANK_CODE")
    public String bank_code;
    @Column(name = "BANK_NAME")
    public String bank_name;
    @Column(name = "RETURN_CODE")
    public String return_code;
    @Column(name = "SHEET_NUMBER")
    public String sheet_number;
    @Column(name = "DESCRIPTION")
    public String return_name;
    @Column(name= "PERIODFROM")
    public String PERIODFROM;
    @Column(name= "PERIODEND")
    public String PERIODEND;
    @Column(name = "REPORT_GROUP")
    public String report_group;


}
