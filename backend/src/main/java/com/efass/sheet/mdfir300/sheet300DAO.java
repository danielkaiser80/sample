package com.efass.sheet.mdfir300;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "MDFIR300")

public class sheet300DAO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    public Integer id;

    @Column(name = "CODE")
    public String code;

    @Column(name = "ITEM_DESCRIPTION")
    public String description;

    @Column(name = "AMOUNT")
    public BigDecimal amount;


    public sheet300DAO() {

    }

    public sheet300DAO(Integer id, String code, String description, BigDecimal amount) {
        super();
        this.id = id;
        this.code = code;
        this.description = description;
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal col_1) {
        this.amount = col_1;
    }

}

