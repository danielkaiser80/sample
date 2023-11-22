package com.efass.sheet.mdfir400_15;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_15Repo extends CrudRepository<sheetQdfir400_15DAO, Integer> {
    Optional<sheetQdfir400_15DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_15 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_15DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_15 where code=?", nativeQuery = true)
    sheetQdfir400_15DAO findColumnsByCode(String code);
}
