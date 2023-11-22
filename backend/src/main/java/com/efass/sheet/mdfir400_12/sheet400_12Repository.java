package com.efass.sheet.mdfir400_12;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_12Repository extends CrudRepository<sheet400_12DAO, Integer> {
    Optional<sheet400_12DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_12 where code=?", nativeQuery = true)
    Optional<sheet400_12DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_12 where code=?", nativeQuery = true)
    sheet400_12DAO findColumnsByCode(String code);
}
