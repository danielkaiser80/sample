package com.efass.sheet.mdfir1700;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir1700Repo extends CrudRepository<sheetQdfir1700DAO, Integer> {

    Optional<sheetQdfir1700DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1700 where code=?", nativeQuery = true)
    Optional<sheetQdfir1700DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1700 where code=?", nativeQuery = true)
    sheetQdfir1700DAO findColumnsByCode(String code);

}
