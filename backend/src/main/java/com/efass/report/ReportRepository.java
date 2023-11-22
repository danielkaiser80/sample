package com.efass.report;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ReportRepository extends JpaRepository<ReportDAO, Integer>{

	@Query(value = "SELECT * FROM BOIEFASS.Activity where report_date= ? ", nativeQuery = true)
	ReportDAO findByDate(String Date);

	@Query(value = "SELECT * FROM BOIEFASS.Activity where report_date= ?", nativeQuery = true)
	ReportDAO findByPathDate(String Date);

	@Query(value = "SELECT * FROM BOIEFASS.Activity where user_id= ? and status =?", nativeQuery = true)
	ArrayList<ReportDAO> findAllByUsername(String currentPrincipalName, String status);

	@Query(value = "SELECT * FROM BOIEFASS.Activity where report_date= ?", nativeQuery = true)
	Optional<ReportDAO> findByDates(String string);

	@Query(value = "SELECT ID FROM BOIEFASS.Activity where file_name= ?", nativeQuery = true)
	String findByFilename(String filename);

	@Query(value = "SELECT * FROM BOIEFASS.Activity where status= ?", nativeQuery = true)
	Iterable<ReportDAO> findAllByStatus(String status);

	@Query(value = "DELETE FROM BOIEFASS.Activity where status= ?", nativeQuery = true)
	void deleteByStatus(String status);

	@Query(value = "SELECT FILE_NAME FROM BOIEFASS.Activity where  ID= ?", nativeQuery = true)
	String fileReportRepo(int fileId);

	@Query(value = "DELETE FROM BOIEFASS.Activity where ID= ? AND STATUS='approved'", nativeQuery = true)
	int deletefileById(int id);


}
