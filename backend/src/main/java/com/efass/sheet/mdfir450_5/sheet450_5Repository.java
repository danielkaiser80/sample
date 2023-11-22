package com.efass.sheet.mdfir450_5;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_5Repository extends CrudRepository<sheet450_5DAO, Integer> {
    Optional<sheet450_5DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_5 where code=?", nativeQuery = true)
    Optional<sheet450_5DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_5 where code=?", nativeQuery = true)
    sheet450_5DAO findColumnsByCode(String code);
}
