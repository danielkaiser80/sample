package com.efass.sheet.mdfir161;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
@Entity
@Table(name = "MDFIR161")
public class sheet161DAO {
    @Id
   // @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "NAME_OF_INSTITUTION")
    public String bank_name;

    @Column(name = "INSTITUTION_CODE")
    public String bank_code;

    @Column(name = "TYPE_OF_BALANCE")
    public String type_of_balance;

    @Column(name = "ACCOUNT_NUMBER")
    public String account_number;

    @Column(name = "AMOUNT")
    public BigDecimal amount;

    @Column(name = "REMARKS")
    public String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getType_of_balance() {
        return type_of_balance;
    }

    public void setType_of_balance(String type_of_balance) {
        this.type_of_balance = type_of_balance;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

