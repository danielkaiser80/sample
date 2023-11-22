package com.efass.sheet.mdfir493;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet493Repository extends CrudRepository<sheet493DAO, Integer> {
    Optional<sheet493DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR493 where code=?", nativeQuery = true)
    Optional<sheet493DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR493 where code=?", nativeQuery = true)
    sheet493DAO findColumnsByCode(String code);
}
