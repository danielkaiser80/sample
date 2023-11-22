package com.efass.procedures;

import java.sql.Types;
import java.text.ParseException;
import java.util.Map;


import com.efass.ReportGroupEnum;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

@Repository
public class ProcedureImpl implements ProcedureService {

	@Autowired
	JdbcTemplate jdbcTemplate;


	private SimpleJdbcCall simpleJdbcCall;



	@Override
	public  ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException {
        int i = TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY);
        if (i == 0) {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PROC_MDFIR_EFASS");
            SqlParameterSource inParam = new MapSqlParameterSource()
                .addValue("i_start_dt", start_date, Types.VARCHAR)
                .addValue("i_end_dt", end_date, Types.VARCHAR)
                .addValue("PV_ERROR_CODE", "", Types.VARCHAR)
                .addValue("PV_ERROR_MESSAGE", "", Types.VARCHAR);

            Map<String, Object> records = simpleJdbcCall.execute(inParam);

            String errorCode = "";
            //String errorMessage = "";

            if (records != null) {
                errorCode = (String) records.get("PV_ERROR_CODE");
                //errorMessage = (String) records.get("PV_ERROR_MESSAGE");
            }

            Response res = new Response();
            res.setResponseMessage("Success");
            res.setResponseCode(00);

            // procedure returns 0 for errorCode if successful
            if (errorCode != null) {
                res.setResponseMessage("Failed");
                res.setResponseCode(-1001);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0)
        {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PROC_QDFIR_EFASS");
            SqlParameterSource inParam = new MapSqlParameterSource()
                .addValue("i_start_dt", start_date, Types.VARCHAR)
                .addValue("i_end_dt", end_date, Types.VARCHAR)
                .addValue("PV_ERROR_CODE", "", Types.VARCHAR)
                .addValue("PV_ERROR_MESSAGE", "", Types.VARCHAR);

            Map<String, Object> records = simpleJdbcCall.execute(inParam);

            String errorCode = "";
            //String errorMessage = "";

            errorCode = (String) records.get("PV_ERROR_CODE");
            //errorMessage = (String) records.get("PV_ERROR_MESSAGE");

            Response res = new Response();
            res.setResponseMessage("Success");
            res.setResponseCode(00);

            // procedure returns 0 for errorCode if successful
            if (errorCode != null) {
                res.setResponseMessage("Failed");
                res.setResponseCode(-1001);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return null;
        }

}
