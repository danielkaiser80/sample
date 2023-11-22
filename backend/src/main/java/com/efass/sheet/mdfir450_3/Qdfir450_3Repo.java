package com.efass.sheet.mdfir450_3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_3Repo extends CrudRepository<sheetQdfir450_3DAO, Integer> {
    Optional<sheetQdfir450_3DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_3 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_3DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_3 where code=?", nativeQuery = true)
    sheetQdfir450_3DAO findColumnsByCode(String code);
}
