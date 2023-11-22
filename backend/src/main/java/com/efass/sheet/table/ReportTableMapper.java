package com.efass.sheet.table;

import lombok.Builder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Builder
public class ReportTableMapper implements RowMapper<TabSheet> {
    @Override
    public TabSheet mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TabSheet
                .builder()
                .bank_code(rs.getString("bank_code"))
                .sheet_number(rs.getString("sheet_number"))
                .bank_name(rs.getString("bank_name"))
                .return_code(rs.getString("return_code"))
                .return_name(rs.getString("description"))
                .build();
    }
}
