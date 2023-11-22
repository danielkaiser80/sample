package com.efass.sheet.mdfir1200;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Qdfir1200Repo extends CrudRepository<sheetQdfir1200DAO, Integer> {

	Optional<sheetQdfir1200DAO> findById(int id);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR1200 where code=?", nativeQuery = true)
	Optional<sheetQdfir1200DAO> findByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR1200 where code=?", nativeQuery = true)
	sheetQdfir1200DAO findColumnsByCode(String code);

}
