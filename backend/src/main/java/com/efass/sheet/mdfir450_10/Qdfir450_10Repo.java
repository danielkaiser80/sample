package com.efass.sheet.mdfir450_10;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_10Repo extends CrudRepository<sheetQdfir450_10DAO, Integer> {
    Optional<sheetQdfir450_10DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_10 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_10DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_10 where code=?", nativeQuery = true)
    sheetQdfir450_10DAO findColumnsByCode(String code);
}
