package com.efass.sheet.mdfir333;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Qdfir333Repo extends CrudRepository<sheetQdfir333DAO, Integer> {
    Optional<sheetQdfir333DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR333 where code=?", nativeQuery = true)
    Optional<sheetQdfir333DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QDFIR333 where code=?", nativeQuery = true)
    sheetQdfir333DAO findColumnsByCode(String code);
}
