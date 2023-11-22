package com.efass.sheet.mdfir1650;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
@Entity
@Table(name = "QDFIR1650")
public class sheetQdfir1650DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "CUSTOMER_CODE")
    public String customer_code;
    @Column(name = "CUSTOMER_NAME")
    public String customer_name;
    @Column(name = "ACCOUNT_NUMBER")
    public String account_number;
    @Column(name = "RELATIONSHIP_TO_INSTITUTION")
    public String  relationship_to_institution;
    @Column(name = "AMOUNT_GRANTED")
    public BigDecimal amount_granted;
    @Column(name = "DATE_GRANTED")
    public LocalDate date_granted;
    @Column(name = "EXPIRY_DATE")
    public LocalDate expiry_date;
    @Column(name = "TOTAL_OUTSTANDING_CREDIT")
    public BigDecimal total_outstanding_credit;
    @Column(name = "PERFORMING")
    public String performing;
    @Column(name = "NON_PERFORMING")
    public String non_performing;
    @Column(name = "RATE_OF_INTEREST")
    public BigDecimal rate_of_interest;
    @Column(name = "NATURE")
    public String nature;
    @Column(name = "VALUE")
    public BigDecimal value;
    @Column(name = "DATE_OF_VALUATION")
    public LocalDate date_of_valuation;
    @Column(name = "AMOUNT")
    public BigDecimal amount;
    @Column(name = "REMARKS")
    public BigDecimal remarks;
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
    public String getAccount_number() {
        return account_number;
    }
    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
    public String getRelationship_to_institution() {
        return relationship_to_institution;
    }
    public void setRelationship_to_institution(String relationship_to_institution) {
        this.relationship_to_institution = relationship_to_institution;
    }
    public BigDecimal getAmount_granted() {
        return amount_granted;
    }
    public void setAmount_granted(BigDecimal amount_granted) {
        this.amount_granted = amount_granted;
    }
    public LocalDate getDate_granted() {
        return date_granted;
    }
    public void setDate_granted(LocalDate date_granted) {
        this.date_granted = date_granted;
    }
    public LocalDate getExpiry_date() {
        return expiry_date;
    }
    public void setExpiry_date(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }
    public BigDecimal getTotal_outstanding_credit() {
        return total_outstanding_credit;
    }
    public void setTotal_outstanding_credit(BigDecimal total_outstanding_credit) {
        this.total_outstanding_credit = total_outstanding_credit;
    }
    public String getPerforming() {
        return performing;
    }
    public void setPerforming(String performing) {
        this.performing = performing;
    }
    public String getNon_performing() {
        return non_performing;
    }
    public void setNon_performing(String non_performing) {
        this.non_performing = non_performing;
    }
    public BigDecimal getRate_of_interest() {
        return rate_of_interest;
    }
    public void setRate_of_interest(BigDecimal rate_of_interest) {
        this.rate_of_interest = rate_of_interest;
    }
    public String getNature() {
        return nature;
    }
    public void setNature(String nature) {
        this.nature = nature;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public LocalDate getDate_of_valuation() {
        return date_of_valuation;
    }
    public void setDate_of_valuation(LocalDate date_of_valuation) {
        this.date_of_valuation = date_of_valuation;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getRemarks() {
        return remarks;
    }
    public void setRemarks(BigDecimal remarks) {
        this.remarks = remarks;
    }


}
