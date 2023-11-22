package com.efass.sheet.mdfir161;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir161Repo extends CrudRepository<sheetQdfir161DAO, Integer> {

    Optional<sheetQdfir161DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR161 where code=?", nativeQuery = true)
    Optional<sheetQdfir161DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR161 where code=?", nativeQuery = true)
    sheetQdfir161DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR161", nativeQuery = true)
    int getid();
}
