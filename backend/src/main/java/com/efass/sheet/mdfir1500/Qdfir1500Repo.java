package com.efass.sheet.mdfir1500;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir1500Repo extends CrudRepository<sheetQdfir1500DAO, Integer> {

    Optional<sheetQdfir1500DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1500 where code=?", nativeQuery = true)
    Optional<sheetQdfir1500DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1500 where code=?", nativeQuery = true)
    sheetQdfir1500DAO findColumnsByCode(String code);
}
