package com.efass.sheet.mdfir450_6;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_6Repository extends CrudRepository<sheet450_6DAO, Integer> {
    Optional<sheet450_6DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_6 where code=?", nativeQuery = true)
    Optional<sheet450_6DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_6 where code=?", nativeQuery = true)
    sheet450_6DAO findColumnsByCode(String code);
}
