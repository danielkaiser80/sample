package com.efass.sheet.mdfir191;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir191Repo extends CrudRepository<sheetQdfir191DAO, Integer> {


    Optional<sheetQdfir191DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR191 where code=?", nativeQuery = true)
    Optional<sheetQdfir191DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR191 where code=?", nativeQuery = true)
    sheetQdfir191DAO findColumnsByCode(String code);
}
