package com.efass.sheet.mdfir292_1;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir292_1Repo extends CrudRepository<sheetQdfir292_1DAO, Integer> {
    Optional<sheetQdfir292_1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR292_1 where code=?", nativeQuery = true)
    Optional<sheetQdfir292_1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR292_1 where code=?", nativeQuery = true)
    sheetQdfir292_1DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR292_1", nativeQuery = true)
    int getid();
}
