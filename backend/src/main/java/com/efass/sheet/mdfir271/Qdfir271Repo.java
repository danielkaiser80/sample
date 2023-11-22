package com.efass.sheet.mdfir271;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir271Repo extends CrudRepository<sheetQdfir271DAO, Integer> {
    Optional<sheetQdfir271DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR271 where code=?", nativeQuery = true)
    Optional<sheetQdfir271DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR271 where code=?", nativeQuery = true)
    sheetQdfir271DAO findColumnsByCode(String code);
}
