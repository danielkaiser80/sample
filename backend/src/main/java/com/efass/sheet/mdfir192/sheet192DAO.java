package com.efass.sheet.mdfir192;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "MDFIR192")
public class sheet192DAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name="ACCOUNT_NUMBER")
    public String account_number;

    @Column(name = "AMOUNT")
    public BigDecimal amount;

    @Column(name = "FOREIGN_CURRENCY")
    public String foreign_currency;

    @Column(name="INSTITUTION_CODE")
    public String bankCode;

    @Column(name="NAME_OF_INSTITUTION")
    public String bankName;

    @Column(name="RATE_OF_EXCHANGE")
    public BigDecimal rate_of_exchange;


    public String getForeign_currency() {
        return foreign_currency;
    }

    public void setForeign_currency(String foreign_currency) {
        this.foreign_currency = foreign_currency;
    }

    public BigDecimal getRate_of_exchange() {
        return rate_of_exchange;
    }

    public void setRate_of_exchange(BigDecimal rate_of_exchange) {
        this.rate_of_exchange = rate_of_exchange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
