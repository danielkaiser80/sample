package com.efass.sheet.mdfir921;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface Qdfir921Repo extends CrudRepository<sheetQdfir921DAO, Integer> {

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR921 where code=?", nativeQuery = true)
    Optional<sheetQdfir921DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR921 where code=?", nativeQuery = true)
    sheetQdfir921DAO fingColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR921 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheetQdfir921DAO> findAllOrderByCode();

}
