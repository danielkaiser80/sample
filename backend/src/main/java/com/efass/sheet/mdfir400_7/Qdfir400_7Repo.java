package com.efass.sheet.mdfir400_7;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_7Repo extends CrudRepository<sheetQdfir400_7DAO, Integer> {
    Optional<sheetQdfir400_7DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_7 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_7DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_7 where code=?", nativeQuery = true)
    sheetQdfir400_7DAO findColumnsByCode(String code);
}
