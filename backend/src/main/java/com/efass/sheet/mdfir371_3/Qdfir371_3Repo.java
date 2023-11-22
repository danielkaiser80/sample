package com.efass.sheet.mdfir371_3;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir371_3Repo extends CrudRepository<sheetQdfir371_3DAO, Integer> {
    Optional<sheetQdfir371_3DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR371_3 where code=?", nativeQuery = true)
    Optional<sheetQdfir371_3DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR371_3 where code=?", nativeQuery = true)
    sheetQdfir371_3DAO findColumnsByCode(String code);
}
