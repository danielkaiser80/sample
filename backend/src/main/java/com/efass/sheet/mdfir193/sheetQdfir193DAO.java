package com.efass.sheet.mdfir193;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR193")
public class sheetQdfir193DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "ITEM_DESCRIPTION")
    public String description;

    @Column(name = "AMOUNT_CURRENT_MONTH")
    public BigDecimal amount_current_month;

    @Column(name = "AMOUNT_YEAR_TO_DATE")
    public BigDecimal amount_year_to_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount_current_month() {
        return amount_current_month;
    }

    public void setAmount_current_month(BigDecimal amount_current_month) {
        this.amount_current_month = amount_current_month;
    }

    public BigDecimal getAmount_year_to_date() {
        return amount_year_to_date;
    }

    public void setAmount_year_to_date(BigDecimal amount_year_to_date) {
        this.amount_year_to_date = amount_year_to_date;
    }
}
