package com.efass.sheet.mdfir450_10;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_10Repository extends CrudRepository<sheet450_10DAO, Integer> {
    Optional<sheet450_10DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_10 where code=?", nativeQuery = true)
    Optional<sheet450_10DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_10 where code=?", nativeQuery = true)
    sheet450_10DAO findColumnsByCode(String code);
}
