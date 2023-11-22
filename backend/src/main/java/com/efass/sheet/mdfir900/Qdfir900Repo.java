package com.efass.sheet.mdfir900;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface Qdfir900Repo extends CrudRepository<sheetQdfir900DAO, Integer> {

    Optional<sheetQdfir900DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR900 where code=?", nativeQuery = true)
    Optional<sheetQdfir900DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR900 where code=?", nativeQuery = true)
    sheetQdfir900DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR900 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheetQdfir900DAO> findAllOrderByCode();
}
