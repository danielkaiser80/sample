package com.efass.sheet.mdfir304;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet304Repository extends CrudRepository<sheet304DAO, Integer> {
    Optional<sheet304DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR304 where code=?", nativeQuery = true)
    Optional<sheet304DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR304 where code=?", nativeQuery = true)
    sheet304DAO findColumnsByCode(String code);
}
