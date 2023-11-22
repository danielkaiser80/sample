package com.efass.sheet.mstdr1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MSTDR1")
public class sheet001DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "STATE_CODE")
    public String code;
    @Column(name = "LOCAL_GOVERNMENT_OR_LG_CODE")
    public String local_government_or_lg_code;
    @Column(name = "UP_TO_2_YRS")
    public BigDecimal up_to_2_yrs;
    @Column(name = "SCHEDULE_2_T0_5_YRS")
    public BigDecimal schedule_2_to_5_yrs;
    @Column(name = "SCHEDULE_5_T0_10_YRS")
    public BigDecimal schedule_5_to_10_yrs;
    @Column(name = "OVER_10YRS")
    public BigDecimal over_10yrs;
    @Column(name = "OVER_DRAFT")
    public BigDecimal over_draft;
    @Column(name = "OTHERS")
    public BigDecimal others;
    @Column(name = "TOTAL_1")
    public BigDecimal total_1;
    @Column(name = "UP_TO_2_YRS_1")
    public BigDecimal up_to_2_yrs_1;
    @Column(name = "SCHEDULE_2_T0_5_YRS_1")
    public BigDecimal schedule_2_to_5_yrs_1;
    @Column(name = "SCHEDULE_5_T0_10_YRS_1")
    public BigDecimal schedule_5_to_10_yrs_1;
    @Column(name = "OVER_10YRS_1")
    public BigDecimal over_10yrs_1;
    @Column(name = "TOTAL_2")
    public BigDecimal total_2;
    @Column(name = "CREATE_DT")
    private LocalDate create_dt;

}
