package com.efass.sheet.mdfir422;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet422Repository extends CrudRepository<sheet422DAO, Integer> {
    Optional<sheet422DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR422 where code=?", nativeQuery = true)
    Optional<sheet422DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR422 where code=?", nativeQuery = true)
    sheet422DAO findColumnsByCode(String code);
}
