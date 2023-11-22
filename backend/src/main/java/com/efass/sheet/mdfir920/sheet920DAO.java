package com.efass.sheet.mdfir920;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "MDFIR920")
public class sheet920DAO {
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

}
