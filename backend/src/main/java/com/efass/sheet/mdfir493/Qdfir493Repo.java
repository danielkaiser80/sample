package com.efass.sheet.mdfir493;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir493Repo extends CrudRepository<sheetQdfir493DAO, Integer> {
    Optional<sheetQdfir493DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR493 where code=?", nativeQuery = true)
    Optional<sheetQdfir493DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR493 where code=?", nativeQuery = true)
    sheetQdfir493DAO findColumnsByCode(String code);
}
