package com.efass.sheet.mdfir371_1;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "MDFIR371_1")
public class sheet371_1DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "CARRYING_VALUE")
    public BigDecimal carrying_value;
    @Column(name = "DERIVATIVE_FINANCIAL_ASSETS")
    public String derivative_financial_assets;
    @Column(name = "NOTIONAL_AMOUNT  ")
    public BigDecimal notional_amount;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public BigDecimal getCarrying_value() {
        return carrying_value;
    }
    public void setCarrying_value(BigDecimal carrying_value) {
        this.carrying_value = carrying_value;
    }
    public String getDerivative_financial_assets() {
        return derivative_financial_assets;
    }
    public void setDerivative_financial_assets(String derivative_financial_assets) {
        this.derivative_financial_assets = derivative_financial_assets;
    }
    public BigDecimal getNotional_amount() {
        return notional_amount;
    }
    public void setNotional_amount(BigDecimal notional_amount) {
        this.notional_amount = notional_amount;
    }


}

