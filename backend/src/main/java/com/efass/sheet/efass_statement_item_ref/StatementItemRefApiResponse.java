package com.efass.sheet.efass_statement_item_ref;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatementItemRefApiResponse<T> {
    private String responseMessage;
    private T data;
}
