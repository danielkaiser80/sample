package com.efass.sheet.table;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportDb implements ReportDbService{

    private final JdbcTemplate jdbcTemplate;

    public ReportDb(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TabSheet> queryReportGroup(String report_group) {
        System.out.println("DISPLAY RESULT");
        String query="SELECT SHEET_NUMBER, BANK_CODE, BANK_NAME, RETURN_CODE, DESCRIPTION, REPORT_GROUP FROM BOIEFASS.rpt_template WHERE report_group =  ? ORDER BY SHEET_NUMBER";
       //String query="SELECT A.BANK_CODE, A.BANK_NAME, A.RETURN_CODE, A.DESCRIPTION FROM RPT_TEMPLATE A, RPT_GROUP B WHERE A.REPORT_GROUP = B.REPORT_GROUP AND B.REPORT_GROUP_NAME = ?";
        return jdbcTemplate.query(query, new ReportTableMapper(), report_group);
    }
}
