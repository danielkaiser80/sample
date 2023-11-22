package com.efass.sheet.mdfir493;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "QDFIR493")
public class sheetQdfir493DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "TYPE")
    public String type;
    @Column(name = "ITEM_DESCRIPTION")
    public String  description;
    @Column(name = "LOCATION")
    public String  location;
    @Column(name = "DATE_OF_PURCHASE")
    public LocalDate date_of_purchase;
    @Column(name = "DATE_TRANSFERRED_TO_HELD_FOR_SALE")
    public LocalDate date_transferred_to_held_for_sale;
    @Column(name = "PURCHASE_COST")
    public BigDecimal purchase_cost;
    @Column(name = "CURRENT_BOOK_VALUE")
    public BigDecimal  current_book_value;
    @Column(name = "CURRENT_MARKET_VALUE")
    public BigDecimal current_market_value;
    @Column(name = "REVALUATION_GAIN_OR_LOSS")
    public BigDecimal revaluation_gain_or_loss;
    @Column(name = "REMARKS")
    public String remarks;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public LocalDate getDate_of_purchase() {
        return date_of_purchase;
    }
    public void setDate_of_purchase(LocalDate date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }
    public LocalDate getDate_transferred_to_held_for_sale() {
        return date_transferred_to_held_for_sale;
    }
    public void setDate_transferred_to_held_for_sale(LocalDate date_transferred_to_held_for_sale) {
        this.date_transferred_to_held_for_sale = date_transferred_to_held_for_sale;
    }
    public BigDecimal getPurchase_cost() {
        return purchase_cost;
    }
    public void setPurchase_cost(BigDecimal purchase_cost) {
        this.purchase_cost = purchase_cost;
    }
    public BigDecimal getCurrent_book_value() {
        return current_book_value;
    }
    public void setCurrent_book_value(BigDecimal current_book_value) {
        this.current_book_value = current_book_value;
    }
    public BigDecimal getCurrent_market_value() {
        return current_market_value;
    }
    public void setCurrent_market_value(BigDecimal current_market_value) {
        this.current_market_value = current_market_value;
    }
    public BigDecimal getRevaluation_gain_or_loss() {
        return revaluation_gain_or_loss;
    }
    public void setRevaluation_gain_or_loss(BigDecimal revaluation_gain_or_loss) {
        this.revaluation_gain_or_loss = revaluation_gain_or_loss;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
