package com.efass.sheet.mdfir1600;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir1600Repo extends CrudRepository<sheetQdfir1600DAO, Integer> {

    Optional<sheetQdfir1600DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1600 where code=?", nativeQuery = true)
    Optional<sheetQdfir1600DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1600 where code=?", nativeQuery = true)
    sheetQdfir1600DAO findColumnsByCode(String code);

}
