package com.efass.bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EFASS_BANK_MAP")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EfassBankMap {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "ID")
    public Integer id;
    @Column(name = "INSTITUTION_CODE")
    public String institution_code;

    @Column(name = "INSTITUTION_NAME")
    public String institution_name;

    @Column(name = "ACCOUNT_NUMBER")
    public String account_number;

    @Column(name = "GL_CODE")
    public String gl_code;

}
