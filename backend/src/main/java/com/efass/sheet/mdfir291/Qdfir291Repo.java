package com.efass.sheet.mdfir291;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir291Repo extends CrudRepository<sheetQdfir291DAO, Integer> {
    Optional<sheetQdfir291DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR291 where code=?", nativeQuery = true)
    Optional<sheetQdfir291DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR291 where code=?", nativeQuery = true)
    sheetQdfir291DAO findColumnsByCode(String code);
}
