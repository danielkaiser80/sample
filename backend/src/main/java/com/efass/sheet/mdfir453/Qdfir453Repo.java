package com.efass.sheet.mdfir453;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir453Repo extends CrudRepository<sheetQdfir453DAO, Integer> {
    Optional<sheetQdfir453DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR453 where code=?", nativeQuery = true)
    Optional<sheetQdfir453DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR453 where code=?", nativeQuery = true)
    sheetQdfir453DAO findColumnsByCode(String code);
}
