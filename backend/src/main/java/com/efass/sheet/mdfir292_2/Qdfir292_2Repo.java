package com.efass.sheet.mdfir292_2;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir292_2Repo extends CrudRepository<sheetQdfir292_2DAO, Integer> {

    Optional<sheetQdfir292_2DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR292_2 where code=?", nativeQuery = true)
    Optional<sheetQdfir292_2DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR292_2 where code=?", nativeQuery = true)
    sheetQdfir292_2DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR292_2", nativeQuery = true)
    int getid();
}
