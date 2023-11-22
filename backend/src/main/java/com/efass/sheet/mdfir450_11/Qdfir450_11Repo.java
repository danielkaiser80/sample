package com.efass.sheet.mdfir450_11;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_11Repo extends CrudRepository<sheetQdfir450_11DAO, Integer> {
    Optional<sheetQdfir450_11DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_11 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_11DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_11 where code=?", nativeQuery = true)
    sheetQdfir450_11DAO findColumnsByCode(String code);
}
