package com.efass.sheet.mdfir193;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir193Repo extends CrudRepository<sheetQdfir193DAO, Integer> {

    Optional<sheetQdfir193DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR193 where code=?", nativeQuery = true)
    Optional<sheetQdfir193DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR193 where code=?", nativeQuery = true)
    sheetQdfir193DAO findColumnsByCode(String code);
}
