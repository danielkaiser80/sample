package com.efass.sheet.mdfir533;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR533")
public class sheetQdfir533DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "CODE")
    public String code;
    @Column(name = "ITEM_DESCRIPTION")
    public String description;
    @Column(name = "GROSS_AMOUNT")
    public BigDecimal gross_amount;
    @Column(name = "ADDITIONS")
    public BigDecimal  additions;
    @Column(name = "ACCUMULATED_DEPRECIATION")
    public BigDecimal accumulated_depreciation ;
    @Column(name = "IMPAIRMENT")
    public BigDecimal impairment ;
   

    public sheetQdfir533DAO() {

    }

    public sheetQdfir533DAO(Integer id, String code, String description, BigDecimal gross_amount, BigDecimal additions, BigDecimal accumulated_depreciation, BigDecimal impairment) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.gross_amount = gross_amount;
        this.additions = additions;
        this.accumulated_depreciation = accumulated_depreciation;
        this.impairment = impairment;
       // this.carrying_amount = carrying_amount;
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
    public BigDecimal getGross_amount() {
        return gross_amount;
    }
    public void setGross_amount(BigDecimal gross_amount) {
        this.gross_amount = gross_amount;
    }
    public BigDecimal getAdditions() {
        return additions;
    }
    public void setAdditions(BigDecimal additions) {
        this.additions = additions;
    }
    public BigDecimal getAccumulated_depreciation() {
        return accumulated_depreciation;
    }
    public void setAccumulated_depreciation(BigDecimal accumulated_depreciation) {
        this.accumulated_depreciation = accumulated_depreciation;
    }
    public BigDecimal getImpairment() {
        return impairment;
    }
    public void setImpairment(BigDecimal impairment) {
        this.impairment = impairment;
    }
   /* public BigDecimal getCarrying_amount() {
        return carrying_amount;
    }
    public void setCarrying_amount(BigDecimal carrying_amount) {
        this.carrying_amount = carrying_amount;
    }*/
}
