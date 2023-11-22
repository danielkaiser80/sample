package com.efass.sheet.mdfir425;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir425Repo extends CrudRepository<sheetQdfir425DAO, Integer> {
    Optional<sheetQdfir425DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR425 where code=?", nativeQuery = true)
    Optional<sheetQdfir425DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR425 where code=?", nativeQuery = true)
    sheetQdfir425DAO findColumnsByCode(String code);
}
