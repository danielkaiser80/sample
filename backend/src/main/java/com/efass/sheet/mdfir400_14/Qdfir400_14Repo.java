package com.efass.sheet.mdfir400_14;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir400_14Repo extends CrudRepository<sheetQdfir400_14DAO, Integer> {
    Optional<sheetQdfir400_14DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_14 where code=?", nativeQuery = true)
    Optional<sheetQdfir400_14DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR400_14 where code=?", nativeQuery = true)
    sheetQdfir400_14DAO findColumnsByCode(String code);
}
