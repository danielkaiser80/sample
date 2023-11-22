package com.efass.sheet.mdfir363;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR363")
public class sheetQdfir363DAO {
    @Id
    @Column(name = "id")
    public Integer id;
    @Column(name = "TYPE_OF_INVESTMENT")
    public String type_of_investment;
    @Column(name = "PERCENTAGE_1")
    public BigDecimal percentage_1;
    @Column(name = "QUOTED_1")
    public BigDecimal quoted_1;
    @Column(name = "UNQUOTED_1")
    public BigDecimal unquoted_1;
    @Column(name = "PERCENTAGE_2")
    public BigDecimal  percentage_2;
    @Column(name = "QUOTED_2")
    public BigDecimal quoted_2;
    @Column(name = "UNQUOTED_2")
    public BigDecimal unquoted_2;
    @Column(name = "QUOTED_3")
    public BigDecimal quoted_3;
    @Column(name = "UNQUOTED_3")
    public BigDecimal unquoted_3;
    @Column(name = "IMPAIRMENT")
    public BigDecimal impairment;
    @Column(name = "NET_AMOUNT")
    public BigDecimal Net_amount;


	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getType_of_investment() {
        return type_of_investment;
    }
    public void setType_of_investment(String type_of_investment) {
        this.type_of_investment = type_of_investment;
    }
    public BigDecimal getPercentage_1() {
        return percentage_1;
    }
    public void setPercentage_1(BigDecimal percentage_1) {
        this.percentage_1 = percentage_1;
    }
    public BigDecimal getQuoted_1() {
        return quoted_1;
    }
    public void setQuoted_1(BigDecimal quoted_1) {
        this.quoted_1 = quoted_1;
    }
    public BigDecimal getUnquoted_1() {
        return unquoted_1;
    }
    public void setUnquoted_1(BigDecimal unquoted_1) {
        this.unquoted_1 = unquoted_1;
    }
    public BigDecimal getPercentage_2() {
        return percentage_2;
    }
    public void setPercentage_2(BigDecimal percentage_2) {
        this.percentage_2 = percentage_2;
    }
    public BigDecimal getQuoted_2() {
        return quoted_2;
    }
    public void setQuoted_2(BigDecimal quoted_2) {
        this.quoted_2 = quoted_2;
    }
    public BigDecimal getUnquoted_2() {
        return unquoted_2;
    }
    public void setUnquoted_2(BigDecimal unquoted_2) {
        this.unquoted_2 = unquoted_2;
    }
    public BigDecimal getQuoted_3() {
        return quoted_3;
    }
    public void setQuoted_3(BigDecimal quoted_3) {
        this.quoted_3 = quoted_3;
    }
    public BigDecimal getUnquoted_3() {
        return unquoted_3;
    }
    public void setUnquoted_3(BigDecimal unquoted_3) {
        this.unquoted_3 = unquoted_3;
    }
    public BigDecimal getImpairment() {
        return impairment;
    }
    public void setImpairment(BigDecimal impairment) {
        this.impairment = impairment;
    }
    public BigDecimal getNet_amount() {
		return Net_amount;
	}
	public void setNet_amount(BigDecimal net_amount) {
		Net_amount = net_amount;
	}

}
