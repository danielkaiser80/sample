package com.efass.sheet.mdfir1300;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Qdfir1300Repo extends CrudRepository<sheetQdfir1300DAO, Integer>{


	Optional<sheetQdfir1300DAO> findById(int id);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR1300 where code=?", nativeQuery = true)
	Optional<sheetQdfir1300DAO> findByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR1300 where code=?", nativeQuery = true)
	sheetQdfir1300DAO findColumnsByCode(String code);
}
