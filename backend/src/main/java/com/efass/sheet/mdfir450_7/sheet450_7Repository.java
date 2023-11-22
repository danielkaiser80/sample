package com.efass.sheet.mdfir450_7;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_7Repository extends CrudRepository<sheet450_7DAO, Integer> {
    Optional<sheet450_7DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_7 where code=?", nativeQuery = true)
    Optional<sheet450_7DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_7 where code=?", nativeQuery = true)
    sheet450_7DAO findColumnsByCode(String code);
}
