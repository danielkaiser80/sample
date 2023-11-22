package com.efass.sheet.mdfir363;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir363Repo extends CrudRepository<sheetQdfir363DAO, Integer> {
    Optional<sheetQdfir363DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR363 where code=?", nativeQuery = true)
    Optional<sheetQdfir363DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR363 where code=?", nativeQuery = true)
    sheetQdfir363DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR363", nativeQuery = true)
    int getid();
}
