package com.efass.sheet.mdfir450_15;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_15Repository extends CrudRepository<sheet450_15DAO, Integer> {
    Optional<sheet450_15DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_15 where code=?", nativeQuery = true)
    Optional<sheet450_15DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_15 where code=?", nativeQuery = true)
    sheet450_15DAO findColumnsByCode(String code);
}
