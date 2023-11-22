package com.efass.sheet.mdfir221;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "MDFIR221")

public class sheet221DAO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "INSTITUTION_CODE")
    public String bankCode;

    @Column(name = "NAME_OF_INSTITUTION")
    public String bankName;

    @Column(name = "ACCOUNT_NUMBER")
    public String account_number;

    @Column(name = "AMOUNT_1")
    public BigDecimal amount;

    @Column(name = "AMOUNT_2")
    public BigDecimal amount_2;

    @Column(name = "REMARKS")
    public String remarks;

    @Column(name = "TYPE_OF_BALANCE")
    public String type_of_balance;

    public sheet221DAO() {

    }

    public sheet221DAO(Integer id, String bankCode, String bankName, String account_number, BigDecimal amount, BigDecimal amount_2, String remarks, String type_of_balance) {

        this.id = id;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.account_number = account_number;
        this.amount = amount;
        this.amount_2 = amount_2;
        this.remarks = remarks;
        this.type_of_balance = type_of_balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public BigDecimal getAmount_2() {
        return amount_2;
    }

    public void setAmount_2(BigDecimal amount_2) {
        this.amount_2 = amount_2;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getType_of_balance() {
        return type_of_balance;
    }

    public void setType_of_balance(String type_of_balance) {
        this.type_of_balance = type_of_balance;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
