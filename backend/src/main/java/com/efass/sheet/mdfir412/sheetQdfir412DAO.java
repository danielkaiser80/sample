package com.efass.sheet.mdfir412;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR412")
public class sheetQdfir412DAO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "AMOUNT")
    public BigDecimal amount;

    @Column(name = "ITEM_DESCRIPTION")
    public String description;

    public sheetQdfir412DAO() {
    }

    public sheetQdfir412DAO(Integer id, BigDecimal amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

