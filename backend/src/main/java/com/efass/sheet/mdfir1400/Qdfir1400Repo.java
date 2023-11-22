package com.efass.sheet.mdfir1400;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir1400Repo extends CrudRepository<sheetQdfir1400DAO, Integer> {

    Optional<sheetQdfir1400DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1400 where code=?", nativeQuery = true)
    Optional<sheetQdfir1400DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1400 where code=?", nativeQuery = true)
    sheetQdfir1400DAO findColumnsByCode(String code);
}
