package com.efass.sheet.mdfir101;


import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sheet101Repository extends CrudRepository<sheet101DAO, Integer> {
	Optional<sheet101DAO> findById(int id);

	@Query(value = "SELECT * FROM BOIEFASS.MDFIR101 where code=?", nativeQuery = true)
	Optional<sheet101DAO> findByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.MDFIR101 where code=?", nativeQuery = true)
	sheet101DAO findColumnsByCode(String code);

	 @Query(value = "SELECT count(*) FROM BOIEFASS.MDFIR101", nativeQuery = true)
	    int getid();
}
