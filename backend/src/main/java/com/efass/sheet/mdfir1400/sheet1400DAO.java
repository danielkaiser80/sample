package com.efass.sheet.mdfir1400;

import javax.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "MDFIR1400")
public class sheet1400DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "BRANCH_CODE ")
    public String branch_code;
    @Column(name = "BRANCH_NAME")
    public String branch_name;
    @Column(name = "TOTAL_OTHER_ASSETS")
    public BigDecimal total_other_assets;
    @Column(name = "TOTAL_NON_OTHER_PERFORMING_ASSETS ")
    public BigDecimal  total_non_other_performing_assets;
    @Column(name = "WATCH_LIST")
    public BigDecimal watch_list;
    @Column(name = "SUBSTANDARD")
    public BigDecimal substandard;
    @Column(name = "DOUBTFUL")
    public BigDecimal doubtful;
    @Column(name = "VERY_DOUBTFUL")
    public BigDecimal very_doubtful;
    @Column(name = "LOST")
    public BigDecimal lost;
    @Column(name = "DFI_PROVISION")
    public BigDecimal dfi_provision;
    @Column(name = "REMARKS")
    public String remarks;

    public sheet1400DAO() {
    }

    public sheet1400DAO(Integer id, String branch_code, String branch_name, BigDecimal total_other_assets, BigDecimal total_non_other_performing_assets, BigDecimal watch_list, BigDecimal substandard, BigDecimal doubtful, BigDecimal very_doubtful, BigDecimal lost, BigDecimal dfi_provision, String remarks) {
        this.id = id;
        this.branch_code = branch_code;
        this.branch_name = branch_name;
        this.total_other_assets = total_other_assets;
        this.total_non_other_performing_assets = total_non_other_performing_assets;
        this.watch_list = watch_list;
        this.substandard = substandard;
        this.doubtful = doubtful;
        this.very_doubtful = very_doubtful;
        this.lost = lost;
        this.dfi_provision = dfi_provision;
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public BigDecimal getTotal_other_assets() {
        return total_other_assets;
    }

    public void setTotal_other_assets(BigDecimal total_other_assets) {
        this.total_other_assets = total_other_assets;
    }

    public BigDecimal getTotal_non_other_performing_assets() {
        return total_non_other_performing_assets;
    }

    public void setTotal_non_other_performing_assets(BigDecimal total_non_other_performing_assets) {
        this.total_non_other_performing_assets = total_non_other_performing_assets;
    }

    public BigDecimal getWatch_list() {
        return watch_list;
    }

    public void setWatch_list(BigDecimal watch_list) {
        this.watch_list = watch_list;
    }

    public BigDecimal getSubstandard() {
        return substandard;
    }

    public void setSubstandard(BigDecimal substandard) {
        this.substandard = substandard;
    }

    public BigDecimal getDoubtful() {
        return doubtful;
    }

    public void setDoubtful(BigDecimal doubtful) {
        this.doubtful = doubtful;
    }

    public BigDecimal getVery_doubtful() {
        return very_doubtful;
    }

    public void setVery_doubtful(BigDecimal very_doubtful) {
        this.very_doubtful = very_doubtful;
    }

    public BigDecimal getLost() {
        return lost;
    }

    public void setLost(BigDecimal lost) {
        this.lost = lost;
    }

    public BigDecimal getDfi_provision() {
        return dfi_provision;
    }

    public void setDfi_provision(BigDecimal dfi_provision) {
        this.dfi_provision = dfi_provision;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
