package com.efass.sheet.mdfir372;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir372Repo extends CrudRepository<sheetQdfir372DAO, Integer> {
    Optional<sheetQdfir372DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR372 where code=?", nativeQuery = true)
    Optional<sheetQdfir372DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR372 where code=?", nativeQuery = true)
    sheetQdfir372DAO findColumnsByCode(String code);
}
