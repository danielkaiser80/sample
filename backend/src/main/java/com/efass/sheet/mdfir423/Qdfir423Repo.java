package com.efass.sheet.mdfir423;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir423Repo extends CrudRepository<sheetQdfir423DAO, Integer> {
    Optional<sheetQdfir423DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR423 where code=?", nativeQuery = true)
    Optional<sheetQdfir423DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR423 where code=?", nativeQuery = true)
    sheetQdfir423DAO findColumnsByCode(String code);
}
