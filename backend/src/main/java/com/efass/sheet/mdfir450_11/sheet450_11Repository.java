package com.efass.sheet.mdfir450_11;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_11Repository extends CrudRepository<sheet450_11DAO, Integer> {
    Optional<sheet450_11DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_11 where code=?", nativeQuery = true)
    Optional<sheet450_11DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_11 where code=?", nativeQuery = true)
    sheet450_11DAO findColumnsByCode(String code);
}
