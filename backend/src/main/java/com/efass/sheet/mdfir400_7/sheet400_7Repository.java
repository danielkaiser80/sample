package com.efass.sheet.mdfir400_7;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_7Repository extends CrudRepository<sheet400_7DAO, Integer> {
    Optional<sheet400_7DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_7 where code=?", nativeQuery = true)
    Optional<sheet400_7DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_7 where code=?", nativeQuery = true)
    sheet400_7DAO findColumnsByCode(String code);
}
