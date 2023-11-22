package com.efass.sheet.mdfir201;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR201")
public class sheetQdfir201DAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name="ACCOUNT_NUMBER")
    public String account_number;

    @Column(name = "AMOUNT")
    public BigDecimal amount;

    @Column(name="INSTITUTION_CODE")
    public String bankCode;

    @Column(name="NAME_OF_INSTITUTION")
    public String bankName;

    @Column(name="REMARKS")
    public String remarks;

    @Column(name="TYPE_OF_BALANCE")
    public String type_of_balance;

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

}
