package com.efass.sheet.mdfir304;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir304Repo extends CrudRepository<sheetQdfir304DAO, Integer> {

    Optional<sheetQdfir304DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR304 where code=?", nativeQuery = true)
    Optional<sheetQdfir304DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR304 where code=?", nativeQuery = true)
    sheetQdfir304DAO findColumnsByCode(String code);
}
