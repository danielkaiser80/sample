package com.efass.sheet.mdfir311;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir311Repo extends CrudRepository<sheetQdfir311DAO, Integer> {

    Optional<sheetQdfir311DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR311 where code=?", nativeQuery = true)
    Optional<sheetQdfir311DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR311 where code=?", nativeQuery = true)
    sheetQdfir311DAO findColumnsByCode(String code);
}
