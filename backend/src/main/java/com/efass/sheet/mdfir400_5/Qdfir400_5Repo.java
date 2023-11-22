package com.efass.sheet.mdfir400_5;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_5Repo extends CrudRepository<sheetQdfir400_5DAO, Integer> {
    Optional<sheetQdfir400_5DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_5 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_5DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_5 where code=?", nativeQuery = true)
    sheetQdfir400_5DAO findColumnsByCode(String code);
}
