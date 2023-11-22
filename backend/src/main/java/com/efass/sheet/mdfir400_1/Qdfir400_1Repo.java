package com.efass.sheet.mdfir400_1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_1Repo extends CrudRepository<sheetQdfir400_1DAO, Integer> {
    Optional<sheetQdfir400_1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400 where code=?", nativeQuery = true)
    sheetQdfir400_1DAO findColumnsByCode(String code);
}
