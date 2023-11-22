package com.efass.sheet.mdfir423;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR423")
public class sheetQdfir423DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;
    @Column(name = "CODE")
    public String code;
    @Column(name = "ITEM_DESCRIPTION")
    public String item_description;

    @Column(name = "AMOUNT")
    public BigDecimal amount;

    public sheetQdfir423DAO() {

    }

    public sheetQdfir423DAO(Integer id, String code, String item_description,  BigDecimal amount) {
        super();
        this.id = id;
        this.code = code;
        this.item_description = item_description;
        this.amount = amount;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
