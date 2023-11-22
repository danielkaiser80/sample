package com.efass.sheet.mdfir182;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet182Repository extends CrudRepository<sheet182DAO, Integer> {
    Optional<sheet182DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR182 where code=?", nativeQuery = true)
    Optional<sheet182DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR182 where code=?", nativeQuery = true)
    sheet182DAO findColumnsByCode(String code);
}
