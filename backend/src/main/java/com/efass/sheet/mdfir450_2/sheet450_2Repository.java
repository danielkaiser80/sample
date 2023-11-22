package com.efass.sheet.mdfir450_2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_2Repository extends CrudRepository<sheet450_2DAO, Integer> {
    Optional<sheet450_2DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_2 where code=?", nativeQuery = true)
    Optional<sheet450_2DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_2 where code=?", nativeQuery = true)
    sheet450_2DAO findColumnsByCode(String code);
}
