package com.efass.sheet.mdfir1700;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "MDFIR1700")
public class sheet1700DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;
    @Column(name = "NAME")
    public String name;
    @Column(name = "SECTOR ")
    public String sector;
    @Column(name = "CRMS_BORROWER_CODE")
    public String  crms_borrower_code;
    @Column(name = "RC_OR_BR_OR_SR_NO")
    public String rc_or_br_or_sr_no;
    @Column(name = "TOTAL")
    public BigDecimal total;
    @Column(name = "CLASSIFIED_AS_NPA")
    public String classified_as_npa;
    @Column(name = "INV")
    public BigDecimal investment;
    @Column(name = "LIABILITIES")
    public BigDecimal liabilities;
    @Column(name = "TOTAL_EXPOSURE")
    public BigDecimal total_exposure;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getCrms_borrower_code() {
        return crms_borrower_code;
    }
    public void setCrms_borrower_code(String crms_borrower_code) {
        this.crms_borrower_code = crms_borrower_code;
    }
    public String getRc_or_br_or_sr_no() {
        return rc_or_br_or_sr_no;
    }
    public void setRc_or_br_or_sr_no(String rc_or_br_or_sr_no) {
        this.rc_or_br_or_sr_no = rc_or_br_or_sr_no;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public String getClassified_as_npa() {
        return classified_as_npa;
    }
    public void setClassified_as_npa(String classified_as_npa) {
        this.classified_as_npa = classified_as_npa;
    }
    public BigDecimal getInvestment() {
        return investment;
    }
    public void setInvestment(BigDecimal investment) {
        this.investment = investment;
    }
    public BigDecimal getLiabilities() {
        return liabilities;
    }
    public void setLiabilities(BigDecimal liabilities) {
        this.liabilities = liabilities;
    }
    public BigDecimal getTotal_exposure() {
        return total_exposure;
    }
    public void setTotal_exposure(BigDecimal total_exposure) {
        this.total_exposure = total_exposure;
    }
}