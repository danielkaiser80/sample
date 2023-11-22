package com.efass.sheet.mdfir400_10;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_10Repository extends CrudRepository<sheet400_10DAO, Integer> {
    Optional<sheet400_10DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_10 where code=?", nativeQuery = true)
    Optional<sheet400_10DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_10 where code=?", nativeQuery = true)
    sheet400_10DAO findColumnsByCode(String code);
}
