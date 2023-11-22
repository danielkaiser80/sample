package com.efass.sheet.mdfir1300;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR1300")
public class sheetQdfir1300DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "CUSTOMER_CODE")
    public String customer_code;
    @Column(name = "CUSTOMER_NAME")
    public String customer_name;
    @Column(name = "TOTAL_CREDIT")
    public BigDecimal total_credit;
    @Column(name = "PRINCIPAL_PAYMENT_DUE_AND_UNPAID")
    public BigDecimal  principal_payment_due_and_unpaid;
    @Column(name = "ACCRUED_INTEREST_UNPAID")
    public BigDecimal accrued_interest_unpaid;
    @Column(name = "TOTAL_OUTSTANDING_CREDITS")
    public BigDecimal total_outstanding_credits ;
    @Column(name = "WATCH_LIST")
    public BigDecimal watch_list ;
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
    public BigDecimal remarks;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCustomer_code() {
        return customer_code;
    }
    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public BigDecimal getTotal_credit() {
        return total_credit;
    }
    public void setTotal_credit(BigDecimal total_credit) {
        this.total_credit = total_credit;
    }
    public BigDecimal getPrincipal_payment_due_and_unpaid() {
        return principal_payment_due_and_unpaid;
    }
    public void setPrincipal_payment_due_and_unpaid(BigDecimal principal_payment_due_and_unpaid) {
        this.principal_payment_due_and_unpaid = principal_payment_due_and_unpaid;
    }
    public BigDecimal getAccrued_interest_unpaid() {
        return accrued_interest_unpaid;
    }
    public void setAccrued_interest_unpaid(BigDecimal accrued_interest_unpaid) {
        this.accrued_interest_unpaid = accrued_interest_unpaid;
    }
    public BigDecimal getTotal_outstanding_credits() {
        return total_outstanding_credits;
    }
    public void setTotal_outstanding_credits(BigDecimal total_outstanding_credits) {
        this.total_outstanding_credits = total_outstanding_credits;
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

    public BigDecimal getRemarks() {
        return remarks;
    }
    public void setRemarks(BigDecimal remarks) {
        this.remarks = remarks;
    }

}
