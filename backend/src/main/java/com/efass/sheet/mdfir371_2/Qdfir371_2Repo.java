package com.efass.sheet.mdfir371_2;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir371_2Repo extends CrudRepository<sheetQdfir371_2DAO, Integer> {
    Optional<sheetQdfir371_2DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR371_2 where code=?", nativeQuery = true)
    Optional<sheetQdfir371_2DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR371_2 where code=?", nativeQuery = true)
    sheetQdfir371_2DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR371_2", nativeQuery = true)
    int getid();
}
