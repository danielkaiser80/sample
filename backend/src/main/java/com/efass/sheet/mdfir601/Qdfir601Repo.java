package com.efass.sheet.mdfir601;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir601Repo extends CrudRepository<sheetQdfir601DAO, Integer> {
    Optional<sheetQdfir601DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR601 where code=?", nativeQuery = true)
    Optional<sheetQdfir601DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR601 where code=?", nativeQuery = true)
    sheetQdfir601DAO findColumnsByCode(String code);
}
