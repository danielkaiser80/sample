package com.efass.sheet.mdfir321;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "QDFIR321")
public class sheetQdfir321DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    public Integer id;
    @Column(name = "NAME_OF_BANK")
    public String bankName;
    @Column(name = "INSTITUTION_CODE")
    public String bankCode;
    @Column(name = "TYPE_OF_PLACEMENTS")
    public String typeOfPlacements;
    @Column(name = "ACCOUNT_NUMBER")
    public String accountNumber;
    @Column(name = "AMOUNT_1")
    public BigDecimal amount;
    @Column(name = "AMOUNT_2")
    public BigDecimal amount2;
    @Column(name = "TENOR")
    public String tenor;
    @Column(name = "EFFECTIVE_DATE")
    public LocalDate effectiveDate;
    @Column(name = "MATURITY_DATE")
    public LocalDate maturityDate;
    @Column(name = "INTEREST_RATE")
    public BigDecimal interestRate;
    @Column(name = "UPFRONT_INTEREST_RECEIVED")
    public BigDecimal upfrontInterestReceived;
    @Column(name = "ACCRUED_INTEREST_RECEIVABLE")
    public BigDecimal accruedInterestReceivable;
    @Column(name = "TIMES_ROLLED_OVER")
    public BigDecimal times_rolled_over;
   	@Column(name = "REMARKS")
    public String  remarks;

    public sheetQdfir321DAO() {
    }

    public sheetQdfir321DAO(Integer id, String bankName, String bankCode, String typeOfPlacements, String account_number, BigDecimal amount, BigDecimal amount2, String tenor, LocalDate effectiveDate, LocalDate maturityDate, BigDecimal interestRate, BigDecimal upfrontInterestReceived, BigDecimal accruedInterestReceivable, BigDecimal times_rolled_over, String remarks) {
        this.id = id;
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.typeOfPlacements = typeOfPlacements;
        this.accountNumber = account_number;
        this.amount = amount;
        this.amount2 = amount2;
        this.tenor = tenor;
        this.effectiveDate = effectiveDate;
        this.maturityDate = maturityDate;
        this.interestRate = interestRate;
        this.upfrontInterestReceived = upfrontInterestReceived;
        this.accruedInterestReceivable = accruedInterestReceivable;   
        this.times_rolled_over = times_rolled_over;
        this.remarks = remarks;
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

    public String getTypeOfPlacements() {
        return typeOfPlacements;
    }

    public void setTypeOfPlacements(String type_of_placements) {
        this.typeOfPlacements = type_of_placements;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String account_number) {
        this.accountNumber = account_number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount2() {
        return amount2;
    }

    public void setAmount2(BigDecimal amount_2) {
        this.amount2 = amount_2;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effective_date) {
        this.effectiveDate = effective_date;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturity_date) {
        this.maturityDate = maturity_date;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interest_rate) {
        this.interestRate = interest_rate;
    }

    public BigDecimal getUpfrontInterestReceived() {
        return upfrontInterestReceived;
    }

    public void setUpfrontInterestReceived(BigDecimal upfront_interest_received) {
        this.upfrontInterestReceived = upfront_interest_received;
    }

    public BigDecimal getAccruedInterestReceivable() {
        return accruedInterestReceivable;
    }

    public void setAccruedInterestReceivable(BigDecimal accrued_interest_receivable) {
        this.accruedInterestReceivable = accrued_interest_receivable;
    }
    
    public BigDecimal getTimes_rolled_over() {
		return times_rolled_over;
	}

	public void setTimes_rolled_over(BigDecimal times_rolled_over) {
		this.times_rolled_over = times_rolled_over;
	}

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
