package com.efass.sheet.mdfir601;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "QDFIR601")
public class sheetQdfir601DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "CUSTOMER_NAME")
    public String customer_name;

    @Column(name = "DATE_APPROVED")
    public LocalDate date_approved;

    @Column(name = "FOREIGN_CURRENCY")
    public String foreign_currency;

    @Column(name = "RATE_OF_EXCHANGE")
    public BigDecimal rate_of_exchange;

    @Column(name = "APPROVED_LIMIT")
    public BigDecimal approved_limit;

    @Column(name = "AMOUNT_DRAWN")
    public BigDecimal amount_drawn;

    public sheetQdfir601DAO() {
    }

    public sheetQdfir601DAO(Integer id, String customer_name, LocalDate date_approved, String foreign_currency, BigDecimal rate_of_exchange, BigDecimal approved_limit, BigDecimal amount_drawn) {
        this.id = id;
        this.customer_name = customer_name;
        this.date_approved = date_approved;
        this.foreign_currency = foreign_currency;
        this.rate_of_exchange = rate_of_exchange;
        this.approved_limit = approved_limit;
        this.amount_drawn = amount_drawn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public LocalDate getDate_approved() {
        return date_approved;
    }

    public void setDate_approved(LocalDate date_approved) {
        this.date_approved = date_approved;
    }

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

    public BigDecimal getApproved_limit() {
        return approved_limit;
    }

    public void setApproved_limit(BigDecimal approved_limit) {
        this.approved_limit = approved_limit;
    }

    public BigDecimal getAmount_drawn() {
        return amount_drawn;
    }

    public void setAmount_drawn(BigDecimal amount_drawn) {
        this.amount_drawn = amount_drawn;
    }

}
