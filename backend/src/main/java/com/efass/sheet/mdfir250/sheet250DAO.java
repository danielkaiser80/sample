package com.efass.sheet.mdfir250;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "MDFIR250")
public class sheet250DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;
    @Column(name = "CODE")
    public String code;
    @Column(name = "ITEM_DESCRIPTION")
    public String description;
    @Column(name = "PERCENTAGE")
    public BigDecimal percentage;
    @Column(name = "CREATE_DT")
    public Date create_dt;

    public sheet250DAO() {
    }

    public sheet250DAO(Integer id, String code, String description, BigDecimal percentage) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.percentage = percentage;
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

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    @PrePersist
    protected void onCreate() {
        create_dt = new Date();
    }
}
