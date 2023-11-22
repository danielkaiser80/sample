package com.efass.sheet.mdfir700;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "MDFIR700")
public class sheet700DAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "CODE")
    public String code;

    @Column(name = "ITEM_DESCRIPTION")
    public String description;

    @Column(name = "OUTSTANDING_AT_BEGINNING_OF_MONTH")
    public BigDecimal outstanding_at_beginning_of_month;

    @Column(name = "OUTSTANDING_AT_END_OF_MONTH")
    public BigDecimal outstanding_at_end_of_month;

    @Column(name = "AVERAGE_OPENING_AND_CLOSING_BALANCE")
    public BigDecimal average_opening_and_closing_balance;

    @Column(name = "PAID_INTEREST_DURING_THE_MONTH")
    public BigDecimal paid_interest_during_the_month;

    public sheet700DAO(){}

    public sheet700DAO(Integer id, String code, String description, BigDecimal outstanding_at_beginning_of_month, BigDecimal outstanding_at_end_of_month, BigDecimal average_opening_and_closing_balance, BigDecimal paid_interest_during_the_month) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.outstanding_at_beginning_of_month = outstanding_at_beginning_of_month;
        this.outstanding_at_end_of_month = outstanding_at_end_of_month;
        this.average_opening_and_closing_balance = average_opening_and_closing_balance;
        this.paid_interest_during_the_month = paid_interest_during_the_month;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getOutstanding_at_beginning_of_month() {
        return outstanding_at_beginning_of_month;
    }

    public void setOutstanding_at_beginning_of_month(BigDecimal outstanding_at_beginning_of_month) {
        this.outstanding_at_beginning_of_month = outstanding_at_beginning_of_month;
    }

    public BigDecimal getOutstanding_at_end_of_month() {
        return outstanding_at_end_of_month;
    }

    public void setOutstanding_at_end_of_month(BigDecimal outstanding_at_end_of_month) {
        this.outstanding_at_end_of_month = outstanding_at_end_of_month;
    }

    public BigDecimal getAverage_opening_and_closing_balance() {
        return average_opening_and_closing_balance;
    }

    public void setAverage_opening_and_closing_balance(BigDecimal average_opening_and_closing_balance) {
        this.average_opening_and_closing_balance = average_opening_and_closing_balance;
    }

    public BigDecimal getPaid_interest_during_the_month() {
        return paid_interest_during_the_month;
    }

    public void setPaid_interest_during_the_month(BigDecimal paid_interest_during_the_month) {
        this.paid_interest_during_the_month = paid_interest_during_the_month;
    }
}
