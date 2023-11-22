package com.efass.sheet.mdfir450_1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_1Repo extends CrudRepository<sheetQdfir450_1DAO, Integer> {
    Optional<sheetQdfir450_1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450 where code=?", nativeQuery = true)
    sheetQdfir450_1DAO findColumnsByCode(String code);
}
