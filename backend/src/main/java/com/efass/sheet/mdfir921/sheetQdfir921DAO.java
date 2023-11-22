package com.efass.sheet.mdfir921;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "QDFIR921")

public class sheetQdfir921DAO {
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

    @Column(name = "DESIGNATION")
    public String designation;

    @Column(name = "SEX")
    public String sex;

    @Column(name = "DATE_OF_BIRTH")
    public LocalDate date_of_birth;

    @Column(name = "NATIONALITY")
    public String nationality;

    @Column(name = "STATE_OF_ORIGIN")
    public String state_of_origin;

    @Column(name = "PASSPORT_NUMBER")
    public String passport_number;

    @Column(name = "NATIONAL_ID_CARD_NUMBER")
    public String national_id_card_number;

    @Column(name = "BRANCH_NAME")
    public String branch_name;

    @Column(name = "BRANCH_CODE")
    public String branch_code;

    @Column(name = "STATE_CODE")
    public String state_code;

    @Column(name = "DEPARTMENT")
    public String department;

    @Column(name = "DATE_OF_FRAUD")
    public LocalDate date_of_fraud;

    @Column(name = "DATE_DISCOVERED")
    public LocalDate date_discovered;

    @Column(name = "AMOUNT_INVOLVED")
    public BigDecimal amount_involved;

    @Column(name = "STATUS")
    public String status;

    @Column(name = "AMOUNT_RECOVERED")
    public BigDecimal amount_recovered;
    
    @Column(name = "ACTUAL_LOSS")
    public BigDecimal actual_loss;

	@Column(name = "TYPES")
    public String type;
    
    @Column(name = "REC_DT")
    public LocalDate date;

    public sheetQdfir921DAO(){}


    public sheetQdfir921DAO(Integer id, String surname, String first_name, String middle_name, String designation, String sex,
    		LocalDate date_of_birth, String nationality, String state_of_origin, String passport_number, String national_id_card_number,
                       String branch_name, String branch_code, String state_code, String department, LocalDate date_of_fraud,
                       LocalDate date_discovered, BigDecimal amount_involved, String status, BigDecimal amount_recovered, BigDecimal actual_loss,String type,  LocalDate date){
        super();
        this.id=id;
        this.surname=surname;
        this.first_name=first_name;
        this.middle_name=middle_name;
        this.designation=designation;
        this.sex=sex;
        this.date_of_birth=date_of_birth;
        this.nationality=nationality;
        this.state_of_origin=state_of_origin;
        this.passport_number=passport_number;
        this.national_id_card_number=national_id_card_number;
        this.branch_name=branch_name;
        this.branch_code=branch_code;
        this.state_code=state_code;
        this.department=department;
        this.date_of_fraud=date_of_fraud;
        this.date_discovered=date_discovered;
        this.amount_involved=amount_involved;
        this.status=status;
        this.amount_recovered=amount_recovered;
        this.type=type;
        this.date=date;
        this.actual_loss=actual_loss;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getState_of_origin() {
        return state_of_origin;
    }

    public void setState_of_origin(String state_of_origin) {
        this.state_of_origin = state_of_origin;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getNational_id_card_number() {
        return national_id_card_number;
    }

    public void setNational_id_card_number(String national_id_card_number) {
        this.national_id_card_number = national_id_card_number;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getState_code() {
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

    public LocalDate getDate_of_fraud() {
        return date_of_fraud;
    }

    public void setDate_of_fraud(LocalDate date_of_fraud) {
        this.date_of_fraud = date_of_fraud;
    }

    public LocalDate getDate_discovered() {
        return date_discovered;
    }

    public void setDate_discovered(LocalDate date_discovered) {
        this.date_discovered = date_discovered;
    }

    public BigDecimal getAmount_involved() {
        return amount_involved;
    }

    public void setAmount_involved(BigDecimal amount_involved) {
        this.amount_involved = amount_involved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount_recovered() {
        return amount_recovered;
    }

    public void setAmount_recovered(BigDecimal amount_recovered) {
        this.amount_recovered = amount_recovered;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public BigDecimal getActual_loss() {
		return actual_loss;
	}


	public void setActual_loss(BigDecimal actual_loss) {
		this.actual_loss = actual_loss;
	}  
}
