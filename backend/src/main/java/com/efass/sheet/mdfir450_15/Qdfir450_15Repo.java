package com.efass.sheet.mdfir450_15;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_15Repo extends CrudRepository<sheetQdfir450_15DAO, Integer> {
    Optional<sheetQdfir450_15DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_15 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_15DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_15 where code=?", nativeQuery = true)
    sheetQdfir450_15DAO findColumnsByCode(String code);
}
