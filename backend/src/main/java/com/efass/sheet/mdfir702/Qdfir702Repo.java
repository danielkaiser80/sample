package com.efass.sheet.mdfir702;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface Qdfir702Repo extends CrudRepository<sheetQdfir702DAO, Integer> {
    Optional<sheetQdfir702DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR702 where code=?", nativeQuery = true)
    Optional<sheetQdfir702DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR702 where code=?", nativeQuery = true)
    sheetQdfir702DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR702 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheetQdfir702DAO> findAllOrderByCode();
}
