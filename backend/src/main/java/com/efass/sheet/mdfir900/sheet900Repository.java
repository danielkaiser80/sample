package com.efass.sheet.mdfir900;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.sheet.mdfir300.sheet300DAO;

import java.util.ArrayList;
import java.util.Optional;
@Repository
public interface sheet900Repository extends CrudRepository<sheet900DAO, Integer> {
    Optional<sheet900DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR900 where code=?", nativeQuery = true)
    Optional<sheet900DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR900 where code=?", nativeQuery = true)
    sheet900DAO findColumnsByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.MDFIR900 ORDER BY CODE ASC", nativeQuery = true)
		ArrayList<sheet900DAO> findAllOrderByCode();
}
