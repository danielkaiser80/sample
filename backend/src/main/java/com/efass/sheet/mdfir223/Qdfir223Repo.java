package com.efass.sheet.mdfir223;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir223Repo extends CrudRepository<sheetQdfir223DAO, Integer> {
    Optional<sheetQdfir223DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR223 where code=?", nativeQuery = true)
    Optional<sheetQdfir223DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR223 where code=?", nativeQuery = true)
    sheetQdfir223DAO findColumnsByCode(String code);
}
