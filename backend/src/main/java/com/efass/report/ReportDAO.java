package com.efass.report;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class ReportDAO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
	public int id;
	
	
	@Column(name = "USER_ID")
	public String user_id;
	
	@Column(name = "REPORT_DATE")
	public String report_date;
	
	@Column(name = "FILE_NAME")
	public String file_name;
	
	
	@Column(name = "FILE_PATH")
	public String file_path;

	@Column(name = "STATUS")
	public String status;
	

	public ReportDAO() {
	
	}

	public ReportDAO(int id, String user_id, String report_date, String file_name, String file_path, String status) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.report_date = report_date;
		this.file_name = file_name;
		this.file_path = file_path;
		this.status = status;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getReport_date() {
		return report_date;
	}


	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}


	public String getFile_name() {
		return file_name;
	}


	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}


	public String getFile_path() {
		return file_path;
	}


	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	

}
