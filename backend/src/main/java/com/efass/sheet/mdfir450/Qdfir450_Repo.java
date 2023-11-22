package com.efass.sheet.mdfir450;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_Repo extends CrudRepository<sheetQdfir450_DAO, Integer> {
    Optional<sheetQdfir450_DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450 where code=?", nativeQuery = true)
    sheetQdfir450_DAO findColumnsByCode(String code);
}
