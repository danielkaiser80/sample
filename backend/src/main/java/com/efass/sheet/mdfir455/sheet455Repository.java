package com.efass.sheet.mdfir455;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
@Repository
public interface sheet455Repository extends CrudRepository<sheet455DAO, Integer> {
    Optional<sheet455DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR455 where code=?", nativeQuery = true)
    Optional<sheet455DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR455 where code=?", nativeQuery = true)
    sheet455DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR455 where code=?", nativeQuery = true)
	ArrayList<sheet455DAO> findAllOrderByCode();

	/* @Query(value = "SELECT * FROM BOIEFASS.MDFIR455 ORDER BY CODE ASC", nativeQuery = true)
		ArrayList<sheet455DAO> findAllOrderByCode();*/
}
