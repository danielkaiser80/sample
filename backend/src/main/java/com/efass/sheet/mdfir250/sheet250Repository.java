package com.efass.sheet.mdfir250;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.sheet.mdfir300.sheet300DAO;

import java.util.ArrayList;
import java.util.Optional;
@Repository
public interface sheet250Repository extends CrudRepository<sheet250DAO, Integer> {
    Optional<sheet250DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR250 where code=?", nativeQuery = true)
    Optional<sheet250DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR250 where code=?", nativeQuery = true)
    sheet250DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR250 ORDER BY CODE ASC", nativeQuery = true)
	ArrayList<sheet250DAO> findAllOrderByCode();
}
