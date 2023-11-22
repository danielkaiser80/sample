package com.efass.sheet.mdfir271;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet271Repository extends CrudRepository<sheet271DAO, Integer> {
    Optional<sheet271DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR271 where code=?", nativeQuery = true)
    Optional<sheet271DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR271 where code=?", nativeQuery = true)
    sheet271DAO findColumnsByCode(String code);
}
