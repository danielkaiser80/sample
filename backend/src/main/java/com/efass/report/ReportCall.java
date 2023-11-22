package com.efass.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportCall {


	@Autowired
	JdbcTemplate jdbcTemplate;

	public String fetchDate(String date) {

		String newDate = null;
		try {
//			String sql = "SELECT * FROM  BOIEFASS.Activity  where report_date= ?";
//			listReport = jdbcTemplate.query(sql, new Object[] { date },
//					BeanPropertyRowMapper.newInstance(ReportDAO.class));
//			System.out.println(listReport.get(0).getReport_date());



			     String query = "select report_date from BOIEFASS.Activity where report_date=?";
					Object[] inputs = new Object[] { date };
					 newDate = jdbcTemplate.queryForObject(query, inputs, String.class);

			return newDate;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return newDate;
		}
	}

}
