package com.efass.sheet.mdfir450_3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_3Repository extends CrudRepository<sheet450_3DAO, Integer> {
    Optional<sheet450_3DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_3 where code=?", nativeQuery = true)
    Optional<sheet450_3DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_3 where code=?", nativeQuery = true)
    sheet450_3DAO findColumnsByCode(String code);
}
