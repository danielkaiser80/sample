package com.efass.sheet.mdfir450_13;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_13Repo extends CrudRepository<sheetQdfir450_13DAO, Integer> {
    Optional<sheetQdfir450_13DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_13 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_13DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_13 where code=?", nativeQuery = true)
    sheetQdfir450_13DAO findColumnsByCode(String code);
}
