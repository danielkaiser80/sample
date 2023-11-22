package com.efass.sheet.mdfir400_4;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_4Repo extends CrudRepository<sheetQdfir400_4DAO, Integer> {
    Optional<sheetQdfir400_4DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_4 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_4DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_4 where code=?", nativeQuery = true)
    sheetQdfir400_4DAO findColumnsByCode(String code);
}
