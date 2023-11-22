package com.efass.sheet.mdfir142;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir142Repo extends CrudRepository<sheetQdfir142DAO, Integer> {

    Optional<sheetQdfir142DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR142 where code=?", nativeQuery = true)
    Optional<sheetQdfir142DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR142 where code=?", nativeQuery = true)
    sheetQdfir142DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR142 ", nativeQuery = true)
    int getid();
}
