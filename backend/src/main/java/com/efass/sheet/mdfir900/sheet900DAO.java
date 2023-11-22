package com.efass.sheet.mdfir900;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "MDFIR900")
public class sheet900DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "CUSTOMER_CODE")
    public String customer_code;

    @Column(name = "CUSTOMER_NAME")
    public String customer_name;

    @Column(name = "TYPE_OF_FACILITY")
    public String type_of_facility;

    @Column(name = "AMOUNT_GRANTED")
    public BigDecimal amount_granted;

    @Column(name = "DATE_GRANTED")
    public LocalDate date_granted;

    @Column(name = "EXPIRY_DATE")
    public LocalDate expiry_date;

    @Column(name = "UNUTILISED_CREDIT")
    public BigDecimal unutilised_credit;

    @Column(name = "OUTSTANDING_CREDIT")
    public BigDecimal outstanding_credit;

    @Column(name = "DEBT_INSTRUMENTS")
    public BigDecimal debt_instruments;

    @Column(name = "TOTAL")
    public BigDecimal total;

    @Column(name = "STATUS")
    public String status;

    @Column(name = "DATE_UTILIZATION_ON_EXCEEDED_LIMIT")
    public LocalDate date_utilization_on_exceeded_limit;

    @Column(name = "CBN_APPROVAL")
    public LocalDate cbn_approval;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getType_of_facility() {
        return type_of_facility;
    }

    public void setType_of_facility(String type_of_facility) {
        this.type_of_facility = type_of_facility;
    }

    public BigDecimal getAmount_granted() {
        return amount_granted;
    }

    public void setAmount_granted(BigDecimal amount_granted) {
        this.amount_granted = amount_granted;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }

    public BigDecimal getUnutilised_credit() {
        return unutilised_credit;
    }

    public void setUnutilised_credit(BigDecimal unutilised_credit) {
        this.unutilised_credit = unutilised_credit;
    }

    public BigDecimal getOutstanding_credit() {
        return outstanding_credit;
    }

    public void setOutstanding_credit(BigDecimal outstanding_credit) {
        this.outstanding_credit = outstanding_credit;
    }

    public BigDecimal getDebt_instruments() {
        return debt_instruments;
    }

    public void setDebt_instruments(BigDecimal debt_instruments) {
        this.debt_instruments = debt_instruments;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate_utilization_on_exceeded_limit() {
        return date_utilization_on_exceeded_limit;
    }

    public void setDate_utilization_on_exceeded_limit(LocalDate date_utilization_on_exceeded_limit) {
        this.date_utilization_on_exceeded_limit = date_utilization_on_exceeded_limit;
    }

    public LocalDate getCbn_approval() {
        return cbn_approval;
    }

    public void setCbn_approval(LocalDate cbn_approval) {
        this.cbn_approval = cbn_approval;
    }

    public LocalDate getDate_granted() {
        return date_granted;
    }

    public void setDate_granted(LocalDate date_granted) {
        this.date_granted = date_granted;
    }

}
