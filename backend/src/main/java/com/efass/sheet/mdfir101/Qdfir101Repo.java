package com.efass.sheet.mdfir101;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Qdfir101Repo extends CrudRepository<sheetQdfir101DAO, Integer> {

	Optional<sheetQdfir101DAO> findById(int id);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR101 where code=?", nativeQuery = true)
	Optional<sheetQdfir101DAO> findByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR101 where code=?", nativeQuery = true)
	sheetQdfir101DAO findColumnsByCode(String code);

	 @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR101", nativeQuery = true)
	    int getid();

}
