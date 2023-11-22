package com.efass.sheet.mdfir450_8;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_8Repository extends CrudRepository<sheet450_8DAO, Integer> {
    Optional<sheet450_8DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_8 where code=?", nativeQuery = true)
    Optional<sheet450_8DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_8 where code=?", nativeQuery = true)
    sheet450_8DAO findColumnsByCode(String code);
}
