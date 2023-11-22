package com.efass.sheet.mstdr1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qstdr1Repo extends CrudRepository<sheetQstdr1DAO, Integer> {

    Optional<sheetQstdr1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QSTDR1 where state_code=?", nativeQuery = true)
    Optional<sheetQstdr1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QSTDR1 where state_code=?", nativeQuery = true)
    sheetQstdr1DAO findColumnsByCode(String code);
}
