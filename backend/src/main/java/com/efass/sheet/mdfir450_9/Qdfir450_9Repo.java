package com.efass.sheet.mdfir450_9;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_9Repo extends CrudRepository<sheetQdfir450_9DAO, Integer> {
    Optional<sheetQdfir450_9DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_9 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_9DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_9 where code=?", nativeQuery = true)
    sheetQdfir450_9DAO findColumnsByCode(String code);
}
