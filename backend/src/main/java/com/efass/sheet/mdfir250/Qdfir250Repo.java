package com.efass.sheet.mdfir250;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir250Repo extends CrudRepository<sheetQdfir250DAO, Integer> {
    Optional<sheetQdfir250DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR250 where code=?", nativeQuery = true)
    Optional<sheetQdfir250DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR250 where code=?", nativeQuery = true)
    sheetQdfir250DAO findColumnsByCode(String code);
}
