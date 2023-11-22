package com.efass.sheet.mdfir600;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MDFIR600")
public class sheet600DAO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "CODE")
    public String code;

    @Column(name = "ITEM_DESCRIPTION")
    public String description;

    @Column(name = "TERM_LOAN")
    public BigDecimal term_loan;

    @Column(name = "OVER_DRAFT")
    public BigDecimal over_draft;

    @Column(name = "OTHERS_1")
    public String others_1;

    @Column(name = "ADVANCES_UNDER_LEASE")
    public BigDecimal advances_under_lease;

    @Column(name = "BANKERS_ACCEPTANCES")
    public String bankers_acceptances;

    @Column(name = "COMMERCIAL_PAPERS")
    public String commercial_papers;

    @Column(name = "BILLS_DISCOUNTED")
    public BigDecimal bills_discounted;

    @Column(name = "OTHERS_2")
    public String others_2;

    @Column(name = "CREATE_DT")
    public Date create_dt;



    public sheet600DAO() {

    }

    public sheet600DAO(int id, String code, String description, BigDecimal term_loan, BigDecimal over_draft, String others_1,
                            BigDecimal advances_under_lease, String bankers_acceptances, String commercial_papers, BigDecimal bills_discounted,
                            String others_2){
        this.id=id;
        this.code=code;
        this.description=description;
        this.term_loan=term_loan;
        this.over_draft=over_draft;
        this.others_1=others_1;
        this.advances_under_lease=advances_under_lease;
        this.bankers_acceptances=bankers_acceptances;
        this.commercial_papers=commercial_papers;
        this.bills_discounted=bills_discounted;
        this.others_2 = others_2;
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

    public BigDecimal getTerm_loan() {
        return term_loan;
    }

    public void setTerm_loan(BigDecimal term_loan) {
        this.term_loan = term_loan;
    }

    public BigDecimal getOver_draft() {
        return over_draft;
    }

    public void setOver_draft(BigDecimal over_draft) {
        this.over_draft = over_draft;
    }

    public String getOthers_1() {
        return others_1;
    }

    public void setOthers_1(String others_1) {
        this.others_1 = others_1;
    }

    public BigDecimal getAdvances_under_lease() {
        return advances_under_lease;
    }

    public void setAdvances_under_lease(BigDecimal advances_under_lease) {
        this.advances_under_lease = advances_under_lease;
    }

    public String getBankers_acceptances() {
        return bankers_acceptances;
    }

    public void setBankers_acceptances(String bankers_acceptances) {
        this.bankers_acceptances = bankers_acceptances;
    }

    public String getCommercial_papers() {
        return commercial_papers;
    }

    public void setCommercial_papers(String commercial_papers) {
        this.commercial_papers = commercial_papers;
    }

    public BigDecimal getBills_discounted() {
        return bills_discounted;
    }

    public void setBills_discounted(BigDecimal bills_discounted) {
        this.bills_discounted = bills_discounted;
    }

    public String getOthers_2() {
        return others_2;
    }

    public void setOthers_2(String others_2) {
        this.others_2 = others_2;
    }

    @PrePersist
    protected void onCreate() {
        create_dt = new Date();
    }
}
