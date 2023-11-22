package com.efass.sheet.mdfir400_9;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_9Repo extends CrudRepository<sheetQdfir400_9DAO, Integer> {
    Optional<sheetQdfir400_9DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_9 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_9DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_9 where code=?", nativeQuery = true)
    sheetQdfir400_9DAO findColumnsByCode(String code);
}
