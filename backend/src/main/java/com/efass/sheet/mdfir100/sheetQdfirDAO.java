package com.efass.sheet.mdfir100;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR100")
public class sheetQdfirDAO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;
    @Column(name = "CODE")
    public String code;
	@Column(name = "ITEM_DESCRIPTION")
    public String description;
    @Column(name = "NUMBER_1")
    public BigDecimal number_1;
    @Column(name = "VALUE_1")
    public BigDecimal value_1;
    @Column(name = "NUMBER_2")
    public BigDecimal number_2;
    @Column(name = "VALUE_2")
    public BigDecimal value_2;

    public sheetQdfirDAO() {

    }

    public sheetQdfirDAO(Integer id, String code, String description, BigDecimal number_1, BigDecimal value_1, BigDecimal number_2, BigDecimal value_2) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.number_1 = number_1;
		this.value_1 = value_1;
		this.number_2 = number_2;
		this.value_2 = value_2;
		
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
	public BigDecimal getNumber_1() {
		return number_1;
	}
	public void setNumber_1(BigDecimal number_1) {
		this.number_1 = number_1;
	}
	public BigDecimal getValue_1() {
		return value_1;
	}
	public void setValue_1(BigDecimal value_1) {
		this.value_1 = value_1;
	}
	public BigDecimal getNumber_2() {
		return number_2;
	}
	public void setNumber_2(BigDecimal number_2) {
		this.number_2 = number_2;
	}
	public BigDecimal getValue_2() {
		return value_2;
	}
	public void setValue_2(BigDecimal value_2) {
		this.value_2 = value_2;
	}
}
