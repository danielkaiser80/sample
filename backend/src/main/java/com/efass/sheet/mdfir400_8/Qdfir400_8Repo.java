package com.efass.sheet.mdfir400_8;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_8Repo extends CrudRepository<sheetQdfir400_8DAO, Integer> {
    Optional<sheetQdfir400_8DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_8 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_8DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_8 where code=?", nativeQuery = true)
    sheetQdfir400_8DAO findColumnsByCode(String code);
}
