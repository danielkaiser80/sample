package com.efass.sheet.mdfir372;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "MDFIR372")
public class sheet372DAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name="CUSTOMER_CODE")
    public String customer_code;

    @Column(name = "CUSTOMER_NAME")
    public String customer_name;

    @Column(name="PRINCIPAL_GRANTED")
    public BigDecimal principal_granted;

    @Column(name="PURPOSE")
    public String purpose;

    @Column(name="DATE_GRANTED")
    public LocalDate date_granted;

    @Column(name="DUE_DATE")
    public LocalDate due_date;

    @Column(name="PRINCIPAL_OUTSTANDING")
    public BigDecimal principal_outstanding;

    @Column(name="INTEREST_RATE")
    public BigDecimal interest_rate;

    @Column(name="UPFRONT_INTEREST")
    public BigDecimal upfront_interest;

    @Column(name="INTEREST_PAYABLE")
    public BigDecimal interest_payable;

    @Column(name="UNPAID_PRINCIPAL_OR_INTEREST")
    public BigDecimal unpaid_principal_interest;

    @Column(name="TIMES_ROLLED_OVER")
    public String times_rolled_over;

    @Column(name="COLL_OR_VALUE")
    public String coll_or_value;

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

    public BigDecimal getPrincipal_granted() {
        return principal_granted;
    }

    public void setPrincipal_granted(BigDecimal principal_granted) {
        this.principal_granted = principal_granted;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LocalDate getDate_granted() {
        return date_granted;
    }

    public void setDate_granted(LocalDate date_granted) {
        this.date_granted = date_granted;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }

    public BigDecimal getPrincipal_outstanding() {
        return principal_outstanding;
    }

    public void setPrincipal_outstanding(BigDecimal principal_outstanding) {
        this.principal_outstanding = principal_outstanding;
    }

    public BigDecimal getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(BigDecimal interest_rate) {
        this.interest_rate = interest_rate;
    }

    public BigDecimal getUpfront_interest() {
        return upfront_interest;
    }

    public void setUpfront_interest(BigDecimal upfront_interest) {
        this.upfront_interest = upfront_interest;
    }

    public BigDecimal getInterest_payable() {
        return interest_payable;
    }

    public void setInterest_payable(BigDecimal interest_payable) {
        this.interest_payable = interest_payable;
    }

    public BigDecimal getUnpaid_principal_interest() {
        return unpaid_principal_interest;
    }

    public void setUnpaid_principal_interest(BigDecimal unpaid_principal_interest) {
        this.unpaid_principal_interest = unpaid_principal_interest;
    }

    public String getTimes_rolled_over() {
        return times_rolled_over;
    }

    public void setTimes_rolled_over(String times_rolled_over) {
        this.times_rolled_over = times_rolled_over;
    }

    public String getColl_or_value() {
        return coll_or_value;
    }

    public void setColl_or_value(String coll_or_value) {
        this.coll_or_value = coll_or_value;
    }


}
