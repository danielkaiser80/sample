package com.efass.sheet.mdfir400;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400Repo extends CrudRepository<sheetQdfir400_DAO, Integer> {
	Optional<sheetQdfir400_DAO> findById(int id);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR400 where code=?", nativeQuery = true)
	Optional<sheetQdfir400_DAO> findByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR400 where code=?", nativeQuery = true)
	sheetQdfir400_DAO findColumnsByCode(String code);
}
