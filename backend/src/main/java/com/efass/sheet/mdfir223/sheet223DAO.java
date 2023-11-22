package com.efass.sheet.mdfir223;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "MDFIR223")
public class sheet223DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "INVESTEE_NAME")
    public String investee_name;
    @Column(name = "TYPE_OF_INVESTMENT")
    public String type_of_investment;
    @Column(name = "INVESTMENT_CERTIFICATE_NUMBER")
    public String  investement_cert_number;
    @Column(name = "AMOUNT_INVESTED")
    public BigDecimal amount_invested;
    @Column(name = "FAIR_VALUE_GAIN_OR_LOSSES")
    public BigDecimal fair_value_gain_or_loss;
    @Column(name = "IMPAIRMENT")
    public BigDecimal impairment;
    @Column(name = "CARRYING_AMOUNT_QUOTED_EQUITY_INVESTMENT")
    public BigDecimal carrying_amt_quoted_eq_inv;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getInvestee_name() {
        return investee_name;
    }
    public void setInvestee_name(String investee_name) {
        this.investee_name = investee_name;
    }
    public String getType_of_investment() {
        return type_of_investment;
    }
    public void setType_of_investment(String type_of_investment) {
        this.type_of_investment = type_of_investment;
    }
    public String getInvestement_cert_number() {
        return investement_cert_number;
    }
    public void setInvestement_cert_number(String investement_cert_number) {
        this.investement_cert_number = investement_cert_number;
    }
    public BigDecimal getAmount_invested() {
        return amount_invested;
    }
    public void setAmount_invested(BigDecimal amount_invested) {
        this.amount_invested = amount_invested;
    }
    public BigDecimal getFair_value_gain_or_loss() {
        return fair_value_gain_or_loss;
    }
    public void setFair_value_gain_or_loss(BigDecimal fair_value_gain_or_loss) {
        this.fair_value_gain_or_loss = fair_value_gain_or_loss;
    }
    public BigDecimal getImpairment() {
        return impairment;
    }
    public void setImpairment(BigDecimal impairment) {
        this.impairment = impairment;
    }
    public BigDecimal getCarrying_amt_quoted_eq_inv() {
        return carrying_amt_quoted_eq_inv;
    }
    public void setCarrying_amt_quoted_eq_inv(BigDecimal carrying_amt_quoted_eq_inv) {
        this.carrying_amt_quoted_eq_inv = carrying_amt_quoted_eq_inv;
    }
}
