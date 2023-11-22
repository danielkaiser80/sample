package com.efass.sheet.mdfir400_9;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_9Repository extends CrudRepository<sheet400_9DAO, Integer> {
    Optional<sheet400_9DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_9 where code=?", nativeQuery = true)
    Optional<sheet400_9DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_9 where code=?", nativeQuery = true)
    sheet400_9DAO findColumnsByCode(String code);
}
