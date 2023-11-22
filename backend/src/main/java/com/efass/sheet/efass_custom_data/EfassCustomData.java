package com.efass.sheet.efass_custom_data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "EFASS_CUSTOM_DATA")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EfassCustomData {
    @Id
    @Column(name = "REF_CD", unique = true)
    private String refCd;

    @Column(name = "REF_DESC")
    private String refDesc;

    @Column(name = "REF_TYPE")
    private String refType;

    @Column(name = "REF_VALUE")
    private String refValue;

    @Column(name = "CREATE_DT")
    private LocalDateTime createDt;
}
