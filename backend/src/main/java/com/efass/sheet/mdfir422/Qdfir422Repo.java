package com.efass.sheet.mdfir422;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir422Repo extends CrudRepository<sheetQdfir422DAO, Integer> {
    Optional<sheetQdfir422DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR422 where code=?", nativeQuery = true)
    Optional<sheetQdfir422DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR422 where code=?", nativeQuery = true)
    sheetQdfir422DAO findColumnsByCode(String code);
}
