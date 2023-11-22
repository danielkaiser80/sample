package com.efass.sheet.mstdr2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "QSTDR2")
public class sheetQstdr2DAO {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "STATE_CODE")
    public String state_code;
    @Column(name = "STATE")
    public String state;
    @Column(name = "UP_TO_2_YRS")
    public String up_to_2_yrs;
    @Column(name = "SCHEDULE_2_T0_5_YRS")
    public String schedule_2_to_5_yrs;
    @Column(name = "SCHEDULE_5_T0_10_YRS")
    public String schedule_5_to_10_yrs;
    @Column(name = "OVER_10YRS")
    public String over_10yrs;
    @Column(name = "SUBTOTAL_1")
    public String subtotal_1;
    @Column(name = "OVER_DRAFT_1")
    public String over_draft_1;
    @Column(name = "OTHERS")
    public String others;
    @Column(name = "TOTAL_1")
    public String total_1;
    @Column(name = "UP_TO_2_YRS_1")
    public String up_to_2_yrs_1;
    @Column(name = "SCHEDULE_2_T0_5_YRS_1")
    public String schedule_2_to_5_yrs_1;
    @Column(name = "SCHEDULE_5_T0_10_YRS_1")
    public String schedule_5_to_10_yrs_1;
    @Column(name = "OVER_10YRS_1")
    public String over_10yrs_1;
    @Column(name = "SUBTOTAL_2")
    public String subtotal_2;
    @Column(name = "OVER_DRAFT_2")
    public String over_draft_2;
    @Column(name = "OTHERS_1")
    public String others_1;
    @Column(name = "TOTAL_2")
    public String total_2;
    @Column(name = "UP_TO_2_YRS_2")
    public String up_to_2_yrs_2;
    @Column(name = "SCHEDULE_2_T0_5_YRS_2")
    public String schedule_2_to_5_yrs_2;
    @Column(name = "SCHEDULE_5_T0_10_YRS_2")
    public String schedule_5_to_10_yrs_2;
    @Column(name = "OVER_10YRS_2")
    public String over_10yrs_2;
    @Column(name = "TOTAL_3")
    public String total_3;
}
