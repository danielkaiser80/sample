package com.efass.sheet.mdfir400_3;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_3Repo extends CrudRepository<sheetQdfir400_3DAO, Integer> {
    Optional<sheetQdfir400_3DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_3 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_3DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_3 where code=?", nativeQuery = true)
    sheetQdfir400_3DAO findColumnsByCode(String code);
}
