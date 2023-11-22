package com.efass.sheet.mdfir1301;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR1301")
public class sheetQdfir1301DAO {
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
    @Column(name = "TOTAL_IMPAIRED_CREDITS")
    public BigDecimal total_impaired_credits ;
    @Column(name = "IMPAIRMENT")
    public BigDecimal impairment ;
    @Column(name = "REMARKS")
    public String remarks;
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
    public BigDecimal getTotal_impaired_credits() {
        return total_impaired_credits;
    }
    public void setTotal_impaired_credits(BigDecimal total_impaired_credits) {
        this.total_impaired_credits = total_impaired_credits;
    }
    public BigDecimal getImpairment() {
        return impairment;
    }
    public void setImpairment(BigDecimal impairment) {
        this.impairment = impairment;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
