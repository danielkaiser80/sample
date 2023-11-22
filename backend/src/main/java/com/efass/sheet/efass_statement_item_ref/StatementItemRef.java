package com.efass.sheet.efass_statement_item_ref;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EFASS_STATEMENT_ITEM_REF")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatementItemRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "STATEMENT_CODE")
    private String statementCode;

    @Column(name = "ITEM_CODE")
    private String itemCode;

    @Column(name = "ITEM_DESCRIPTION")
    private String itemDescription;

    @Column(name = "CREATE_DT")
    private LocalDateTime createDt;

}
