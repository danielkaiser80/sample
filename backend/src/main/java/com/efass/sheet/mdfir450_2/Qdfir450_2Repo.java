package com.efass.sheet.mdfir450_2;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_2Repo extends CrudRepository<sheetQdfir450_2DAO, Integer> {
    Optional<sheetQdfir450_2DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_2 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_2DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_2 where code=?", nativeQuery = true)
    sheetQdfir450_2DAO findColumnsByCode(String code);
}
