package com.efass.sheet.mdfir450_4;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_4Repo extends CrudRepository<sheetQdfir450_4DAO, Integer> {
    Optional<sheetQdfir450_4DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_4 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_4DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_4 where code=?", nativeQuery = true)
    sheetQdfir450_4DAO findColumnsByCode(String code);
}
