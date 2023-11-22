package com.efass.sheet.mdfir450_4;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "QDFIR450_4")
public class sheetQdfir450_4DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "ACCRUED_INTEREST_PAYABLE")
    public BigDecimal accrued_interest_payable;
    @Column(name = "AMOUNT_INVESTED")
    public BigDecimal amount_invested;
    @Column(name = "IMPAIRMENT")
    public BigDecimal impairment;
    @Column(name = "INTEREST_RATE")
    public BigDecimal  interest_rate;
    @Column(name = "INVESTED_CERTIFICATE_NUMBER")
    public BigDecimal invested_certificate_number ;
    @Column(name = "EFFECTIVE_DATE")
    public LocalDate effective_date ;
    @Column(name = "MATURITY_DATE")
    public LocalDate maturity_date ;
    @Column(name = "PRINCIPAL_PAYABLE")
    public BigDecimal principal_payable;
    @Column(name = "TENOR")
    public BigDecimal  tenor;
    @Column(name = "TIMES_ROLLED_OVER")
    public BigDecimal times_rolled_over ;

    @Column(name = "TYPES")
    public String type ;
    @Column(name = "UPFRONT_INTEREST_PAID")
    public BigDecimal upfront_interest_paid ;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public BigDecimal getAccrued_interest_payable() {
        return accrued_interest_payable;
    }
    public void setAccrued_interest_payable(BigDecimal accrued_interest_payable) {
        this.accrued_interest_payable = accrued_interest_payable;
    }
    public BigDecimal getAmount_invested() {
        return amount_invested;
    }
    public void setAmount_invested(BigDecimal amount_invested) {
        this.amount_invested = amount_invested;
    }
    public BigDecimal getImpairment() {
        return impairment;
    }
    public void setImpairment(BigDecimal impairment) {
        this.impairment = impairment;
    }
    public BigDecimal getInterest_rate() {
        return interest_rate;
    }
    public void setInterest_rate(BigDecimal interest_rate) {
        this.interest_rate = interest_rate;
    }
    public BigDecimal getInvested_certificate_number() {
        return invested_certificate_number;
    }
    public void setInvested_certificate_number(BigDecimal invested_certificate_number) {
        this.invested_certificate_number = invested_certificate_number;
    }
    public LocalDate getEffective_date() {
        return effective_date;
    }
    public void setEffective_date(LocalDate effective_date) {
        this.effective_date = effective_date;
    }
    public LocalDate getMaturity_date() {
        return maturity_date;
    }
    public void setMaturity_date(LocalDate maturity_date) {
        this.maturity_date = maturity_date;
    }

    public BigDecimal getPrincipal_payable() {
        return principal_payable;
    }
    public void setPrincipal_payable(BigDecimal principal_payable) {
        this.principal_payable = principal_payable;
    }
    public BigDecimal getTenor() {
        return tenor;
    }
    public void setTenor(BigDecimal tenor) {
        this.tenor = tenor;
    }
    public BigDecimal getTimes_rolled_over() {
        return times_rolled_over;
    }
    public void setTimes_rolled_over(BigDecimal times_rolled_over) {
        this.times_rolled_over = times_rolled_over;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public BigDecimal getUpfront_interest_paid() {
        return upfront_interest_paid;
    }
    public void setUpfront_interest_paid(BigDecimal upfront_interest_paid) {
        this.upfront_interest_paid = upfront_interest_paid;
    }
}
