package com.efass.sheet.mdfir382;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir382Repo extends CrudRepository<sheetQdfir382DAO, Integer> {
    Optional<sheetQdfir382DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR382 where code=?", nativeQuery = true)
    Optional<sheetQdfir382DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR382 where code=?", nativeQuery = true)
    sheetQdfir382DAO findColumnsByCode(String code);
}
