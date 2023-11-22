package com.efass.sheet.mdfir201;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.report.ReportDAO;

@Repository
public interface sheet201Repository extends CrudRepository<sheet201DAO, Integer>{



	@Query(value = "select * from BOIEFASS.MDFIR201 where DURATION=? order by CREATE_DT ", nativeQuery = true)
	ArrayList<sheet201DAO> findByDuration(String duration);


}
