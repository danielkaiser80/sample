package com.efass.sheet.efass_statement_item_ref.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatementItemRefRequest {
    private String statementCode;
    private String itemCode;
    private String itemDescription;
}
