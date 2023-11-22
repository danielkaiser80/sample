package com.efass.sheet.mdfir172;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir172Repo extends CrudRepository<sheetQdfir172DAO, Integer> {

    Optional<sheetQdfir172DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR172 where code=?", nativeQuery = true)
    Optional<sheetQdfir172DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR172 where code=?", nativeQuery = true)
    sheetQdfir172DAO findColumnsByCode(String code);
}
