package com.efass.sheet.mdfir292_3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir292_3Repo extends CrudRepository<sheetQdfir292_3DAO, Integer> {

    Optional<sheetQdfir292_3DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR292_3 where code=?", nativeQuery = true)
    Optional<sheetQdfir292_3DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR292_3 where code=?", nativeQuery = true)
    sheetQdfir292_3DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR292_3", nativeQuery = true)
    int getid();
}
