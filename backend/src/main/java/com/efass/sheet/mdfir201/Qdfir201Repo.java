package com.efass.sheet.mdfir201;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir201Repo extends CrudRepository<sheetQdfir201DAO, Integer> {

    Optional<sheetQdfir201DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR201 where code=?", nativeQuery = true)
    Optional<sheetQdfir201DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR201 where code=?", nativeQuery = true)
    sheetQdfir201DAO findColumnsByCode(String code);


}
