
package com.efass.sheet.mdfir300;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Repository
public interface sheet300Repository extends CrudRepository<sheet300DAO, Integer>{


	@Query(value = "SELECT * FROM BOIEFASS.MDFIR300 where code=?", nativeQuery = true)
	Optional<sheet300DAO> findByCode(String code);


	@Query(value = "SELECT * FROM BOIEFASS.MDFIR300 where code=?", nativeQuery = true)
	sheet300DAO findColumnsByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.MDFIR300 ORDER BY CODE ASC", nativeQuery = true)
	ArrayList<sheet300DAO> findAllOrderByCode();


}
