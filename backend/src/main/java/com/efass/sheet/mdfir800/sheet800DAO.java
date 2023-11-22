package com.efass.sheet.mdfir800;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "MDFIR800")
public class sheet800DAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "CODE")
    public String code;

    @Column(name = "ITEM_DESCRIPTION")
    public String description;

    @Column(name = "DEMAND")
    public BigDecimal demand;

    @Column(name = "SAVING")
    public BigDecimal saving;

    @Column(name = "UP_TO_90_DAYS")
    public BigDecimal up_to_90_days;

    @Column(name = "SCHEDULE_91_180_DAYS")
    public BigDecimal schedule_91_to_180_days;

    @Column(name = "SCHEDULE_181_365_DAYS")
    public BigDecimal schedule_181_to_365_days;

    @Column(name = "OVER_365_DAYS")
    public BigDecimal over_365_days;


    public sheet800DAO() {
    }


    public sheet800DAO(int id, String code, String description, BigDecimal demand, BigDecimal saving, BigDecimal up_to_90_days,
                            BigDecimal schedule_91_to_180_days, BigDecimal schedule_181_to_365_days, BigDecimal over_365_days) {
        super();
        this.id = id;
        this.code = code;
        this.description = description;
        this.demand = demand;
        this.saving = saving;
        this.up_to_90_days = up_to_90_days;
        this.schedule_91_to_180_days = schedule_91_to_180_days;
        this.schedule_181_to_365_days = schedule_181_to_365_days;
        this.over_365_days = over_365_days;

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

    public BigDecimal getDemand() {
        return demand;
    }

    public void setDemand(BigDecimal demand) {
        this.demand = demand;
    }

    public BigDecimal getSaving() {
        return saving;
    }

    public void setSaving(BigDecimal saving) {
        this.saving = saving;
    }

    public BigDecimal getUp_to_90_days() {
        return up_to_90_days;
    }

    public void setUp_to_90_days(BigDecimal up_to_90_days) {
        this.up_to_90_days = up_to_90_days;
    }

    public BigDecimal getSchedule_91_to_180_days() {
        return schedule_91_to_180_days;
    }

    public void setSchedule_91_to_180_days(BigDecimal schedule_91_to_180_days) {
        this.schedule_91_to_180_days = schedule_91_to_180_days;
    }

    public BigDecimal getSchedule_181_to_365_days() {
        return schedule_181_to_365_days;
    }

    public void setSchedule_181_to_365_days(BigDecimal schedule_181_to_365_days) {
        this.schedule_181_to_365_days = schedule_181_to_365_days;
    }

    public BigDecimal getOver_365_days() {
        return over_365_days;
    }

    public void setOver_365_days(BigDecimal over_365_days) {
        this.over_365_days = over_365_days;
    }


}
