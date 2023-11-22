package com.efass.sheet.mdfir122;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR122")
public class sheetQdfir122DAO {
    @Id
   // @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "AMOUNT")
    public BigDecimal amount;

    @Column(name = "ITEM_DESCRIPTION")
    public String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

