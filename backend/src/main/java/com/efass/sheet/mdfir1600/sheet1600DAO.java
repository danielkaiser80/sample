package com.efass.sheet.mdfir1600;

import javax.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "MDFIR1600")
public class sheet1600DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "LOAN_OR_FACILITIES_TYPE")
    public BigDecimal loan_or_facilities_type;
    @Column(name = "AGGREGATE_AMOUNT_PRINCIPAL")
    public BigDecimal aggregate_amt_principal;
    @Column(name = "AGGREGATE_AMOUNT_ACCRUED_INTEREST")
    public BigDecimal aggregate_amt_accrued_interest;
    @Column(name = "AGGREGATE_AMOUNT_TOTAL_OUTSTANDING")
    public BigDecimal aggregate_amt_total_outstanding;

    public sheet1600DAO() {
    }

    public sheet1600DAO(Integer id, BigDecimal loan_or_facilities_type, BigDecimal aggregate_amt_principal, BigDecimal aggregate_amt_accrued_interest, BigDecimal aggregate_amt_total_outstanding) {
        this.id = id;
        this.loan_or_facilities_type = loan_or_facilities_type;
        this.aggregate_amt_principal = aggregate_amt_principal;
        this.aggregate_amt_accrued_interest = aggregate_amt_accrued_interest;
        this.aggregate_amt_total_outstanding = aggregate_amt_total_outstanding;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLoan_or_facilities_type() {
        return loan_or_facilities_type;
    }

    public void setLoan_or_facilities_type(BigDecimal loan_or_facilities_type) {
        this.loan_or_facilities_type = loan_or_facilities_type;
    }

    public BigDecimal getAggregate_amt_principal() {
        return aggregate_amt_principal;
    }

    public void setAggregate_amt_principal(BigDecimal aggregate_amt_principal) {
        this.aggregate_amt_principal = aggregate_amt_principal;
    }

    public BigDecimal getAggregate_amt_accrued_interest() {
        return aggregate_amt_accrued_interest;
    }

    public void setAggregate_amt_accrued_interest(BigDecimal aggregate_amt_accrued_interest) {
        this.aggregate_amt_accrued_interest = aggregate_amt_accrued_interest;
    }

    public BigDecimal getAggregate_amt_total_outstanding() {
        return aggregate_amt_total_outstanding;
    }

    public void setAggregate_amt_total_outstanding(BigDecimal aggregate_amt_total_outstanding) {
        this.aggregate_amt_total_outstanding = aggregate_amt_total_outstanding;
    }
}
