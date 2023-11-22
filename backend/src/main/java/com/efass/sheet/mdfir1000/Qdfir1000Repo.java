package com.efass.sheet.mdfir1000;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.sheet.mdfir300.sheetQdfir300DAO;

import java.util.Optional;

@Repository
public interface Qdfir1000Repo extends CrudRepository<sheetQdfir1000DAO, Integer> {

	Optional<sheetQdfir1000DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1000 where code=?", nativeQuery = true)
    Optional<sheetQdfir1000DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR1000 where code=?", nativeQuery = true)
    sheetQdfir1000DAO findColumnsByCode(String code);

}
