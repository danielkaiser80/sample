package com.efass.sheet.mdfir291;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "QDFIR291")
public class sheetQdfir291DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "NAME_OF_BANK")
    public String bankName;
    @Column(name = "INSTITUTION_CODE")
    public String bankCode;
    @Column(name = "TYPE_OF_PLACEMENTS")
    public String type_of_placements;
    @Column(name = "ACCOUNT_NUMBER")
    public String account_number;
    @Column(name = "AMOUNT_1")
    public BigDecimal amount;
    @Column(name = "AMOUNT_2")
    public BigDecimal amount_2;
    @Column(name = "TENOR")
    public String tenor;
    @Column(name = "EFFECTIVE_DATE")
    public LocalDate effective_date;
    @Column(name = "MATURITY_DATE")
    public LocalDate maturity_date;
    @Column(name = "INTEREST_RATE")
    public BigDecimal interest_rate;
    @Column(name = "UPFRONT_INTEREST_RECEIVED")
    public BigDecimal upfront_interest_received;
    @Column(name = "ACCRUED_INTEREST_RECEIVABLE")
    public BigDecimal accrued_interest_receivable;
    @Column(name = "TIMES_ROLLED_OVER")
    public BigDecimal times_rolled_over;


    public sheetQdfir291DAO() {
    }

    public sheetQdfir291DAO(Integer id, String bankName, String bankCode, String type_of_placements, String account_number, BigDecimal amount, BigDecimal amount_2, String tenor, LocalDate effective_date, LocalDate maturity_date, BigDecimal interest_rate,BigDecimal upfront_interest_received, BigDecimal accrued_interest_receivable, BigDecimal times_rolled_over) {
        this.id = id;
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.type_of_placements = type_of_placements;
        this.account_number = account_number;
        this.amount = amount;
        this.amount_2 = amount_2;
        this.tenor = tenor;
        this.effective_date = effective_date;
        this.maturity_date = maturity_date;
        this.interest_rate = interest_rate;
        this.upfront_interest_received = upfront_interest_received;
        this.accrued_interest_receivable = accrued_interest_receivable;
        this.times_rolled_over = times_rolled_over;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getType_of_placements() {
        return type_of_placements;
    }

    public void setType_of_placements(String type_of_placements) {
        this.type_of_placements = type_of_placements;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount_2() {
        return amount_2;
    }

    public void setAmount_2(BigDecimal amount_2) {
        this.amount_2 = amount_2;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
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

    public BigDecimal getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(BigDecimal interest_rate) {
        this.interest_rate = interest_rate;
    }

    public BigDecimal getAccrued_interest_receivable() {
        return accrued_interest_receivable;
    }

    public void setAccrued_interest_receivable(BigDecimal accrued_interest_receivable) {
        this.accrued_interest_receivable = accrued_interest_receivable;
    }

    public BigDecimal getTimes_rolled_over() {
        return times_rolled_over;
    }

    public void setTimes_rolled_over(BigDecimal times_rolled_over) {
        this.times_rolled_over = times_rolled_over;
    }

    public BigDecimal getUpfront_interest_received() {
        return upfront_interest_received;
    }

    public void setUpfront_interest_received(BigDecimal upfront_interest_received) {
        this.upfront_interest_received = upfront_interest_received;
    }
    }
