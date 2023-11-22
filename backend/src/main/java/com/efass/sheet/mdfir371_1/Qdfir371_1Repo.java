package com.efass.sheet.mdfir371_1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir371_1Repo extends CrudRepository<sheetQdfir371_1DAO, Integer> {
    Optional<sheetQdfir371_1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR371_1 where code=?", nativeQuery = true)
    Optional<sheetQdfir371_1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR371_1 where code=?", nativeQuery = true)
    sheetQdfir371_1DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR371_1", nativeQuery = true)
    int getid();
}
