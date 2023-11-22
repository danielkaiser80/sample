package com.efass.sheet.mdfir920;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface Qdfir920Repo extends CrudRepository<sheetQdfir920DAO, Integer> {

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR920 where code=?", nativeQuery = true)
    Optional<sheetQdfir920DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR920 where code=?", nativeQuery = true)
    sheetQdfir920DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR920 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheetQdfir920DAO> findAllOrderByCode();
}
