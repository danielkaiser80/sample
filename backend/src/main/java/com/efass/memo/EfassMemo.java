package com.efass.memo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EFASS_MEMO_POSTED", schema = "BOILIVE")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EfassMemo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "MMO_PSTD_ID")
    public Integer id;

    @Column(name = "GL_CODE")
    public String gl_code;

    @Column(name = "GL_DESCRIPTION")
    public String gl_description;

    @Column(name = "DR_CR_IND")
    public String dr_cr_ind;

    @Column(name = "AMOUNT")
    public Integer amount;

    @Column(name = "PERIOD")
    public String period;

    @Column(name = "YEAR")
    public String year;

    @Column(name = "POSTING_IND")
    public String posting_ind;

    @Column(name = "STATUS")
    public String status;

    @Column(name = "CREATE_DT")
    public Date create_dt;

    @Column(name = "CRNCY_ID")
    public Integer crncy_id;

    @Column(name = "CRNCY_CD_ISO")
    public String crncy_cd_iso;

    @PrePersist
    protected void onCreate() {
        create_dt = new Date();
    }
}
