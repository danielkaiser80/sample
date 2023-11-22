package com.efass.sheet.mdfir453;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.sheet.mdfir300.sheet300DAO;

import java.util.ArrayList;
import java.util.Optional;
@Repository
public interface sheet453Repository extends CrudRepository<sheet453DAO, Integer> {
    Optional<sheet453DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR453 where code=?", nativeQuery = true)
    Optional<sheet453DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR453 where code=?", nativeQuery = true)
    sheet453DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR453 ORDER BY CODE ASC", nativeQuery = true)
	ArrayList<sheet453DAO> findAllOrderByCode();
}
