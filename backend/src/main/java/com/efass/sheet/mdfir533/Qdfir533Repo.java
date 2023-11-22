package com.efass.sheet.mdfir533;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir533Repo extends CrudRepository<sheetQdfir533DAO, Integer> {
    Optional<sheetQdfir533DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR533 where code=?", nativeQuery = true)
    Optional<sheetQdfir533DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR533 where code=?", nativeQuery = true)
    sheetQdfir533DAO findColumnsByCode(String code);
}
