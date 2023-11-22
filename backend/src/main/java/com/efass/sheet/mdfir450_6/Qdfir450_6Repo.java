package com.efass.sheet.mdfir450_6;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_6Repo extends CrudRepository<sheetQdfir450_6DAO, Integer> {
    Optional<sheetQdfir450_6DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_1 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_6DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_1 where code=?", nativeQuery = true)
    sheetQdfir450_6DAO findColumnsByCode(String code);
}
