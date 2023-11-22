package com.efass.sheet.mdfir455;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir455Repo extends CrudRepository<sheetQdfir455DAO, Integer> {
    Optional<sheetQdfir455DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR455 where code=?", nativeQuery = true)
    Optional<sheetQdfir455DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR455 where code=?", nativeQuery = true)
    sheetQdfir455DAO findColumnsByCode(String code);
}
