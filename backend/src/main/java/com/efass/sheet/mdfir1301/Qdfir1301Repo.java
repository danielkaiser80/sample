package com.efass.sheet.mdfir1301;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Qdfir1301Repo extends CrudRepository<sheetQdfir1301DAO, Integer> {

    Optional<sheetQdfir1301DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1301 where code=?", nativeQuery = true)
    Optional<sheetQdfir1301DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1301 where code=?", nativeQuery = true)
    sheetQdfir1301DAO findColumnsByCode(String code);
}
