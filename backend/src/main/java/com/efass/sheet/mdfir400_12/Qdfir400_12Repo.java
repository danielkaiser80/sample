package com.efass.sheet.mdfir400_12;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_12Repo extends CrudRepository<sheetQdfir400_12DAO, Integer> {
    Optional<sheetQdfir400_12DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_12 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_12DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_12 where code=?", nativeQuery = true)
    sheetQdfir400_12DAO findColumnsByCode(String code);
}
