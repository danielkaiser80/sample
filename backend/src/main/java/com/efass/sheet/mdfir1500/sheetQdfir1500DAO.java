package com.efass.sheet.mdfir1500;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR1500")
public class sheetQdfir1500DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "BRANCH_CODE ")
    public String branch_code;
    @Column(name = "BRANCH_NAME")
    public String branch_name;
    @Column(name = "TOTAL_IMPAIRED_CONTINGENT_LIABILITY")
    public BigDecimal total_impaired_contingent_liability;
    @Column(name = "TOTAL_VALUE_OF_CONTINGENT_LIABILITY")
    public BigDecimal  total_value_of_contingent_liability;
    @Column(name = "IMPAIRMENT")
    public BigDecimal impairment;
    @Column(name = "REMARKS")
    public String remarks;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBranch_code() {
        return branch_code;
    }
    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }
    public String getBranch_name() {
        return branch_name;
    }
    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }
    public BigDecimal getTotal_impaired_contingent_liability() {
        return total_impaired_contingent_liability;
    }
    public void setTotal_impaired_contingent_liability(BigDecimal total_impaired_contingent_liability) {
        this.total_impaired_contingent_liability = total_impaired_contingent_liability;
    }
    public BigDecimal getTotal_value_of_contingent_liability() {
        return total_value_of_contingent_liability;
    }
    public void setTotal_value_of_contingent_liability(BigDecimal total_value_of_contingent_liability) {
        this.total_value_of_contingent_liability = total_value_of_contingent_liability;
    }

    public BigDecimal getImpairment() {
        return impairment;
    }

    public void setImpairment(BigDecimal impairment) {
        this.impairment = impairment;
    }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

