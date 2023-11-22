package com.efass.sheet.mdfir450_12;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_12Repository extends CrudRepository<sheet450_12DAO, Integer> {
    Optional<sheet450_12DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_12 where code=?", nativeQuery = true)
    Optional<sheet450_12DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_12 where code=?", nativeQuery = true)
    sheet450_12DAO findColumnsByCode(String code);
}
