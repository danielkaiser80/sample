package com.efass.sheet.mdfir412;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir412Repo extends CrudRepository<sheetQdfir412DAO, Integer> {
    Optional<sheetQdfir412DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR412 where code=?", nativeQuery = true)
    Optional<sheetQdfir412DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR412 where code=?", nativeQuery = true)
    sheetQdfir412DAO findColumnsByCode(String code);
}
