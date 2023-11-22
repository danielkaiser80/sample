package com.efass.sheet.mdfir400;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface sheet400_Repository extends CrudRepository<sheet400_DAO, Integer> {
	Optional<sheet400_DAO> findById(int id);

	@Query(value = "SELECT * FROM BOIEFASS.MDFIR400_1 where code=?", nativeQuery = true)
	Optional<sheet400_DAO> findByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.MDFIR400_1 where code=?", nativeQuery = true)
	sheet400_DAO findColumnsByCode(String code);
}
