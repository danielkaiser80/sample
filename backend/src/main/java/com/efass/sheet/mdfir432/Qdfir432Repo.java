package com.efass.sheet.mdfir432;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir432Repo extends CrudRepository<sheetQdfir432DAO, Integer> {
    Optional<sheetQdfir432DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR432 where code=?", nativeQuery = true)
    Optional<sheetQdfir432DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR432 where code=?", nativeQuery = true)
    sheetQdfir432DAO findColumnsByCode(String code);
}
