package com.efass.sheet.mdfir450_1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet450_1Repository extends CrudRepository<sheet450_1DAO, Integer> {
    Optional<sheet450_1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_1 where code=?", nativeQuery = true)
    Optional<sheet450_1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR450_1 where code=?", nativeQuery = true)
    sheet450_1DAO findColumnsByCode(String code);
}
