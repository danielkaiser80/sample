
package com.efass.sheet.mdfir1000;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "MDFIR1000")
public class sheet1000DAO implements Serializable{

	/**
	 *
	 */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int id;

    @Column(name="CODE")
    public String code;

    @Column(name="ITEM_DESCRIPTION")
    public String description;

    @Column(name="CURRENT_MONTH")
    public BigDecimal currenMonth;

    @Column(name="YEAR_TO_DATE")
    public BigDecimal yearToDate;

    public sheet1000DAO() {

    }

    public sheet1000DAO(int id, String code, String description, BigDecimal currenMonth, BigDecimal yearToDate) {
        super();
        this.id = id;
        this.code = code;
        this.description = description;
        this.currenMonth = currenMonth;
        this.yearToDate = yearToDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public BigDecimal getCurrenMonth() {
        return currenMonth;
    }

    public void setCurrenMonth(BigDecimal col_1) {
        this.currenMonth = col_1;
    }

    public BigDecimal getYearToDate() {
        return yearToDate;
    }

    public void setYearToDate(BigDecimal col_2) {
        this.yearToDate = col_2;
    }

}
