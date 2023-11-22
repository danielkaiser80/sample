package com.efass.sheet.mdfir182;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface Qdfir182Repo extends CrudRepository<sheetQdfir182DAO, Integer> {

    Optional<sheetQdfir182DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR182 where code=?", nativeQuery = true)
    Optional<sheetQdfir182DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR182 where code=?", nativeQuery = true)
    sheetQdfir182DAO findColumnsByCode(String code);
}
