package com.efass.sheet.mdfir920;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "QDFIR920")
public class sheetQdfir920DAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public  Integer id;

    @Column(name = "SURNAME")
    public String surname;

    @Column(name = "FIRST_NAME")
    public String first_name;

    @Column(name = "MIDDLE_NAME")
    public String middle_name;

    @Column(name = "DATE_OF_BIRTH")
    public LocalDate date_of_birth;

    @Column(name = "NATIONAL_ID_CARD_NUMBER")
    public String national_id_card_number;

    @Column(name = "DESIGNATION")
    public String designation;

    @Column(name = "PERMANENT_HOME_ADDRESS")
    public String permanent_home_address;

    @Column(name = "NAME")
    public String name;

    @Column(name = "BRANCH_CODE")
    public String branch_code;

    @Column(name = "STATE_CODE")
    public String state_code;

    @Column(name = "DEPARTMENT")
    public String department;

    @Column(name = "DATE_TERMINATED_OR_DISMISSED")
    public LocalDate date_terminated_or_dismissed;

    @Column(name = "REASONS_FOR_TERMINATION")
    public String reasons_for_termination;

    @Column(name = "DATE_REINSTATED")
    public LocalDate date_reinstated;

    @Column(name = "REASON_FOR_REINSTATEMENT")
    public String reason_for_reinstatement;

    @Column(name = "ORGANISATION")
    public String organization;

    @Column(name = "ADDRESS")
    public String address;

    @Column(name = "DATE_FROM")
    public LocalDate date_from;

    @Column(name = "DATE_TO")
    public LocalDate date_to;

    public sheetQdfir920DAO(){}

    public sheetQdfir920DAO(Integer id, String surname, String middle_name, String first_name, LocalDate date_of_birth,
                       String national_id_card_number, String designation, String permanent_home_address, String name, String branch_code,
                       String state_code, String department, LocalDate date_terminated_or_dismissed, String reasons_for_termination, LocalDate date_reinstated,
                       String reason_for_reinstatement, String organization, String address, LocalDate date_from, LocalDate date_to){
        super();
        this.id=id;
        this.surname=surname;
        this.middle_name=middle_name;
        this.first_name=first_name;
        this.date_of_birth=date_of_birth;
        this.national_id_card_number=national_id_card_number;
        this.designation=designation;
        this.permanent_home_address=permanent_home_address;
        this.name=name;
        this.branch_code=branch_code;
        this.state_code=state_code;
        this.department=department;
        this.date_terminated_or_dismissed=date_terminated_or_dismissed;
        this.reasons_for_termination=reasons_for_termination;
        this.date_reinstated=date_reinstated;
        this.reason_for_reinstatement=reason_for_reinstatement;
        this.organization=organization;
        this.address=address;
        this.date_from=date_from;
        this.date_to=date_to;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getNational_id_card_number() {
        return national_id_card_number;
    }

    public void setNational_id_card_number(String national_id_card_number) {
        this.national_id_card_number = national_id_card_number;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPermanent_home_address() {
        return permanent_home_address;
    }

    public void setPermanent_home_address(String permanent_home_address) {
        this.permanent_home_address = permanent_home_address;
    }

    public String getName(){
        return  name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBranch_code () {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getState_code () {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDate_terminated_or_dismissed() {
        return date_terminated_or_dismissed;
    }

    public void setDate_terminated_or_dismissed(LocalDate date_terminated_or_dismissed) {
        this.date_terminated_or_dismissed = date_terminated_or_dismissed;
    }

    public String getReasons_for_termination() {
        return reasons_for_termination;
    }

    public void setReasons_for_termination(String reasons_for_termination) {
        this.reasons_for_termination = reasons_for_termination;
    }

    public LocalDate getDate_reinstated() {
        return date_reinstated;
    }

    public void setDate_reinstated(LocalDate date_reinstated) {
        this.date_reinstated = date_reinstated;
    }

    public String getReason_for_reinstatement() {
        return reason_for_reinstatement;
    }

    public void setReason_for_reinstatement(String reason_for_reinstatement) {
        this.reason_for_reinstatement = reason_for_reinstatement;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate_from() {
        return date_from;
    }

    public void setDate_from(LocalDate date_from) {
        this.date_from = date_from;
    }

    public LocalDate getDate_to() {
        return date_to;
    }

    public void setDate_to(LocalDate date_to) {
        this.date_to = date_to;
    }


}
