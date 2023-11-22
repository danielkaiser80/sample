package com.efass.sheet.mdfir400_10;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_10Repo extends CrudRepository<sheetQdfir400_10DAO, Integer> {
    Optional<sheetQdfir400_10DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_10 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_10DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_10 where code=?", nativeQuery = true)
    sheetQdfir400_10DAO findColumnsByCode(String code);
}
