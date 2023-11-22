package com.efass.sheet.mdfir450_4;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_4Repository extends CrudRepository<sheet450_4DAO, Integer> {
    Optional<sheet450_4DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_4 where code=?", nativeQuery = true)
    Optional<sheet450_4DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_4 where code=?", nativeQuery = true)
    sheet450_4DAO findColumnsByCode(String code);
}
