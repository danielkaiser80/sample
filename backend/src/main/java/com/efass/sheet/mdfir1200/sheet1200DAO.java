package com.efass.sheet.mdfir1200;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "MDFIR1200")
public class sheet1200DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "CODE")
    public String code;
    @Column(name = "ITEM_DESCRIPTION")
    public String item_description;
    @Column(name = "FROM_1_TO_100000")
    public BigDecimal from_1_to_100000;
    @Column(name = "FROM_100001_TO_200000")
    public BigDecimal from_100001_to_200000;
    @Column(name = "FROM_200001_TO_500000")
    public BigDecimal from_200001_to_500000;
    @Column(name = "OVER_500000")
    public BigDecimal over_500000;


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
    public String getItem_description() {
        return item_description;
    }
    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
    public BigDecimal getFrom_1_to_100000() {
        return from_1_to_100000;
    }
    public void setFrom_1_to_100000(BigDecimal from_1_to_100000) {
        this.from_1_to_100000 = from_1_to_100000;
    }
    public BigDecimal getFrom_100001_to_200000() {
        return from_100001_to_200000;
    }
    public void setFrom_100001_to_200000(BigDecimal from_100001_to_200000) {
        this.from_100001_to_200000 = from_100001_to_200000;
    }
    public BigDecimal getFrom_200001_to_500000() {
        return from_200001_to_500000;
    }
    public void setFrom_200001_to_500000(BigDecimal from_200001_to_500000) {
        this.from_200001_to_500000 = from_200001_to_500000;
    }
    public BigDecimal getOver_500000() {
        return over_500000;
    }
    public void setOver_500000(BigDecimal over_500000) {
        this.over_500000 = over_500000;
    }

}
