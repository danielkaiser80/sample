package com.efass.sheet.mdfir300;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir300Repo extends CrudRepository<sheetQdfir300DAO, Integer> {


    Optional<sheetQdfir300DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR300 where code=?", nativeQuery = true)
    Optional<sheetQdfir300DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR300 where code=?", nativeQuery = true)
    sheetQdfir300DAO findColumnsByCode(String code);
}
