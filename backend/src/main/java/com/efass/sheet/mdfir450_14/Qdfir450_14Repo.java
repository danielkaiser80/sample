package com.efass.sheet.mdfir450_14;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir450_14Repo extends CrudRepository<sheetQdfir450_14DAO, Integer> {
    Optional<sheetQdfir450_14DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_14 where code=?", nativeQuery = true)
    Optional<sheetQdfir450_14DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR450_14 where code=?", nativeQuery = true)
    sheetQdfir450_14DAO findColumnsByCode(String code);
}
