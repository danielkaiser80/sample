package com.efass.sheet.mdfir302;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir302Repo extends CrudRepository<sheetQdfir302DAO, Integer> {


    Optional<sheetQdfir302DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR302 where code=?", nativeQuery = true)
    Optional<sheetQdfir302DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR302 where code=?", nativeQuery = true)
    sheetQdfir302DAO findColumnsByCode(String code);
}
