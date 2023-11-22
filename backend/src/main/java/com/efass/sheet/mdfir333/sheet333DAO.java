package com.efass.sheet.mdfir333;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "MDFIR333")
public class sheet333DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "INVESTEE_NAME")
    public String investee_name;
    @Column(name = "TYPE_OF_INVESTMENT")
    public String type_of_investment;
    @Column(name = "INVESTMENT_CERTIFICATE_NUMBER")
    public String  investment_cert_number;
    @Column(name = "AMOUNT_INVESTED")
    public BigDecimal amount_invested;
    @Column(name = "FAIR_VALUE_GAINS")
    public BigDecimal fair_value_gains;
    @Column(name = "IMPAIRMENT")
    public BigDecimal impairment;
    @Column(name = "CARRYING_VALUE_UNQUOTED_EQUITY_INVESTMENT")
    public BigDecimal carrying_value_unquoted_eq_inv;
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
    public String getInvestment_cert_number() {
        return investment_cert_number;
    }
    public void setInvestement_cert_number(String investement_cert_number) {
        this.investment_cert_number = investement_cert_number;
    }
    public BigDecimal getAmount_invested() {
        return amount_invested;
    }
    public void setAmount_invested(BigDecimal amount_invested) {
        this.amount_invested = amount_invested;
    }
    public BigDecimal getFair_value_gains() {
        return fair_value_gains;
    }
    public void setFair_value_gains(BigDecimal fair_value_gains) {
        this.fair_value_gains = fair_value_gains;
    }
    public BigDecimal getImpairment() {
        return impairment;
    }
    public void setImpairment(BigDecimal impairment) {
        this.impairment = impairment;
    }
    public BigDecimal getCarrying_value_unquoted_eq_inv() {
        return carrying_value_unquoted_eq_inv;
    }
    public void setCarrying_value_unquoted_eq_inv(BigDecimal carrying_value_unquoted_eq_inv) {
        this.carrying_value_unquoted_eq_inv = carrying_value_unquoted_eq_inv;
    }

}
