package com.efass.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "ACTIVITY_EFASS")
public class ActivityDAO {

    @Id
    @Column(name = "ID")
    @JsonIgnore
    public Integer Id;

    @Column(name = "REPORT_DESCRIPTION")
    public String reportDescription;

    @Column(name = "DATE_DESCRIPTION")
    public String dateDescription;

    @Column(name = "CREATE_DT")
    public Timestamp timestamp;

    public ActivityDAO() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public String getDateDescription() {
        return dateDescription;
    }

    public void setDateDescription(String dateDescription) {
        this.dateDescription = dateDescription;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
