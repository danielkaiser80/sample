package com.efass.sheet.table;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface tableRepository extends JpaRepository<TabSheet, Integer> {
   @Query(value = "SELECT BANK_CODE, BANK_NAME, RETURN_CODE, DESCRIPTION FROM " +
       "BOIEFASS.rpt_template WHERE report_group =  ? ORDER BY RETURN_CODE ORDER BY RETURN_CODE", nativeQuery = true)
   Iterable<TabSheet> findByReportGroup(@Param("report_group")String report_group);
}
