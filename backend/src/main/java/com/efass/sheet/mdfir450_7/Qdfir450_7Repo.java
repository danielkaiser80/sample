package com.efass.sheet.mdfir450_7;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_7Repo extends CrudRepository<sheetQdfir450_7DAO, Integer> {
    Optional<sheetQdfir450_7DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_7 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_7DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_7 where code=?", nativeQuery = true)
    sheetQdfir450_7DAO findColumnsByCode(String code);
}
