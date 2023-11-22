package com.efass.sheet.mdfir192;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir192Repo extends CrudRepository<sheetQdfir192DAO, Integer> {

    Optional<sheetQdfir192DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR192 where code=?", nativeQuery = true)
    Optional<sheetQdfir192DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR192 where code=?", nativeQuery = true)
    sheetQdfir192DAO findColumnsByCode(String code);
}
