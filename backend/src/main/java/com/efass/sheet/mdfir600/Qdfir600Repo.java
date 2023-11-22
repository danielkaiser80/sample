package com.efass.sheet.mdfir600;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir600Repo extends CrudRepository<sheetQdfir600DAO, Integer> {
    Optional<sheetQdfir600DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR600 where code=?", nativeQuery = true)
    Optional<sheetQdfir600DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR600 where code=?", nativeQuery = true)
    sheetQdfir600DAO findColumnsByCode(String code);
}
