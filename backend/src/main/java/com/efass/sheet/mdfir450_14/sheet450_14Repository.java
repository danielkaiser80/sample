package com.efass.sheet.mdfir450_14;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_14Repository extends CrudRepository<sheet450_14DAO, Integer> {
    Optional<sheet450_14DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_14 where code=?", nativeQuery = true)
    Optional<sheet450_14DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_14 where code=?", nativeQuery = true)
    sheet450_14DAO findColumnsByCode(String code);
}
