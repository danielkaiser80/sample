package com.efass.sheet.mcfpr1;

import com.efass.sheet.mcfpr1.sheetMcfpr1DAO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "QCFPR1")
public class sheetQcfpr1Dao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "ADDRESS")
    public String address;

    @Column(name = "AMOUNT_CLAIMED_1")
    public BigDecimal amount_claimed_1;

    @Column(name = "AMOUNT_CLAIMED_2")
    public BigDecimal amount_claimed_2;

    @Column(name = "AMOUNT_REFUNDED_1")
    public BigDecimal amount_refunded_1;

    @Column(name = "AMOUNT_REFUNDED_2")
    public BigDecimal amount_refunded_2;

    @Column(name = "CATEGORY")
    public String category;

    @Column(name = "COMPLAINT_REF_NUMBER")
    public String complaint_ref_number;

    @Column(name = "DATE_RECEIVED")
    public LocalDate date_received;

    @Column(name = "DATE_RESOLVED")
    public LocalDate date_resolved;

    @Column(name = "MAJOR_AREAS_OF_DISAGREEMENT")
    public String major_areas_of_disagreement;

    @Column(name = "NAME_OF_PETITIONER")
    public String name_of_petitioner;

    @Column(name = "RESOLUTION_EFFORTS_MADE")
    public String resolution_efforts_made;

    @Column(name = "SUBJECT")
    public String subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getAmount_claimed_1() {
        return amount_claimed_1;
    }

    public void setAmount_claimed_1(BigDecimal amount_claimed_1) {
        this.amount_claimed_1 = amount_claimed_1;
    }

    public BigDecimal getAmount_claimed_2() {
        return amount_claimed_2;
    }

    public void setAmount_claimed_2(BigDecimal amount_claimed_2) {
        this.amount_claimed_2 = amount_claimed_2;
    }

    public BigDecimal getAmount_refunded_1() {
        return amount_refunded_1;
    }

    public void setAmount_refunded_1(BigDecimal amount_refunded_1) {
        this.amount_refunded_1 = amount_refunded_1;
    }

    public BigDecimal getAmount_refunded_2() {
        return amount_refunded_2;
    }

    public void setAmount_refunded_2(BigDecimal amount_refunded_2) {
        this.amount_refunded_2 = amount_refunded_2;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComplaint_ref_number() {
        return complaint_ref_number;
    }

    public void setComplaint_ref_number(String complaint_ref_number) {
        this.complaint_ref_number = complaint_ref_number;
    }

    public LocalDate getDate_received() {
        return date_received;
    }

    public void setDate_received(LocalDate date_received) {
        this.date_received = date_received;
    }

    public LocalDate getDate_resolved() {
        return date_resolved;
    }

    public void setDate_resolved(LocalDate date_resolved) {
        this.date_resolved = date_resolved;
    }

    public String getMajor_areas_of_disagreement() {
        return major_areas_of_disagreement;
    }

    public void setMajor_areas_of_disagreement(String major_areas_of_disagreement) {
        this.major_areas_of_disagreement = major_areas_of_disagreement;
    }

    public String getName_of_petitioner() {
        return name_of_petitioner;
    }

    public void setName_of_petitioner(String name_of_petitioner) {
        this.name_of_petitioner = name_of_petitioner;
    }

    public String getResolution_efforts_made() {
        return resolution_efforts_made;
    }

    public void setResolution_efforts_made(String resolution_efforts_made) {
        this.resolution_efforts_made = resolution_efforts_made;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
