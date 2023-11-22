package com.efass.sheet.mcfpr1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheetMcfpr1Repository extends CrudRepository<sheetMcfpr1DAO, Integer> {
    Optional<sheetMcfpr1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MCFPR1 where code=?", nativeQuery = true)
    Optional<sheetMcfpr1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MCFPR1 where code=?", nativeQuery = true)
    sheetMcfpr1DAO findColumnsByCode(String code);
}
