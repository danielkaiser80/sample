package com.efass.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTROL_PARAMETER")
public class ControlParameterDao {
    @Id
    @Column(name = "CTRL_PARAM_ID", nullable = false)
    @JsonIgnore
    private Integer id;

    @Column(name = "PARAM_CD")
    private String param_code;

    public String getParam_code() {
        return param_code;
    }

    public void setParam_code(String param_code) {
        this.param_code = param_code;
    }

    public String getParam_description() {
        return param_description;
    }

    public void setParam_description(String param_description) {
        this.param_description = param_description;
    }

    public String getParam_value() {
        return param_value;
    }

    public void setParam_value(String param_value) {
        this.param_value = param_value;
    }

    @Column(name = "PARAM_DESC")
    private String param_description;

    @Column(name = "PARAM_VALUE")
    private String param_value;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
