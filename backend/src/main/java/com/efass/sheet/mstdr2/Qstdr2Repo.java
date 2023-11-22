package com.efass.sheet.mstdr2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qstdr2Repo extends CrudRepository<sheetQstdr2DAO, Integer> {

    Optional<sheetQstdr2DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QSTDR2 where code=?", nativeQuery = true)
    Optional<sheetQstdr2DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QSTDR2 where state_code=?", nativeQuery = true)
    sheetQstdr2DAO findColumnsByCode(String code);
}
