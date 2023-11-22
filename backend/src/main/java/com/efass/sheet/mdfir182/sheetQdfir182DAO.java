package com.efass.sheet.mdfir182;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR182")
public class sheetQdfir182DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "INSTITUTION_CODE")
    public String bank_code;

    @Column(name = "NAME_OF_INSTITUTION")
    public String bank_name;

    @Column(name = "ACCOUNT_NUMBER")
    public String account_number;

    @Column(name = "AMOUNT")
    public BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
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

}
