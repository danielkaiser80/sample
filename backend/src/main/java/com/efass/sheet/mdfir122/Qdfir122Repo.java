package com.efass.sheet.mdfir122;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Qdfir122Repo extends CrudRepository<sheetQdfir122DAO, Integer>{


	Optional<sheetQdfir122DAO> findById(int id);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR122 where code=?", nativeQuery = true)
	Optional<sheetQdfir122DAO> findByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.QDFIR122 where code=?", nativeQuery = true)
	sheetQdfir122DAO findColumnsByCode(String code);
}
