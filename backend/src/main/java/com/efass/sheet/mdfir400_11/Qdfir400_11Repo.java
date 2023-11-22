package com.efass.sheet.mdfir400_11;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_11Repo extends CrudRepository<sheetQdfir400_11DAO, Integer> {
    Optional<sheetQdfir400_11DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_11 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_11DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_11 where code=?", nativeQuery = true)
    sheetQdfir400_11DAO findColumnsByCode(String code);
}
