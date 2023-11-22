package com.efass.sheet.mdfir450;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_Repository extends CrudRepository<sheet450_DAO, Integer> {
    Optional<sheet450_DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_1 where code=?", nativeQuery = true)
    Optional<sheet450_DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_1 where code=?", nativeQuery = true)
    sheet450_DAO findColumnsByCode(String code);
}
