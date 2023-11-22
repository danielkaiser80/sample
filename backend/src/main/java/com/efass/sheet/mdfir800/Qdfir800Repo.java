package com.efass.sheet.mdfir800;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Repository
public interface Qdfir800Repo extends CrudRepository<sheetQdfir800DAO, Integer> {

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR800 where code=?", nativeQuery = true)
    Optional<sheetQdfir800DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR800 where code=?", nativeQuery = true)
    sheetQdfir800DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR800 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheetQdfir800DAO> findAllOrderByCode();
}
