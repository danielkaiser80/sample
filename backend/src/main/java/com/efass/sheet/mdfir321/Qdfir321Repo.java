package com.efass.sheet.mdfir321;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir321Repo extends CrudRepository<sheetQdfir321DAO, Integer> {

    Optional<sheetQdfir321DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR321 where code=?", nativeQuery = true)
    Optional<sheetQdfir321DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR321 where code=?", nativeQuery = true)
    sheetQdfir321DAO findColumnsByCode(String code);
}
