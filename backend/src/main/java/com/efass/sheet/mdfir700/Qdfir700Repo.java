package com.efass.sheet.mdfir700;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir700Repo extends CrudRepository<sheetQdfir700DAO, Integer> {
    Optional<sheetQdfir700DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR700 where code=?", nativeQuery = true)
    Optional<sheetQdfir700DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR700 where code=?", nativeQuery = true)
    sheetQdfir700DAO findColumnsByCode(String code);
}
