package com.efass.sheet.mdfir221;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir221Repo extends CrudRepository<sheetQdfir221DAO, Integer> {
    Optional<sheetQdfir221DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR221 where code=?", nativeQuery = true)
    Optional<sheetQdfir221DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR221 where code=?", nativeQuery = true)
    sheetQdfir221DAO findColumnsByCode(String code);
}
