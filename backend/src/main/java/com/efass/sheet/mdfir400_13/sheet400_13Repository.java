package com.efass.sheet.mdfir400_13;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_13Repository extends CrudRepository<sheet400_13DAO, Integer> {
    Optional<sheet400_13DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_13 where code=?", nativeQuery = true)
    Optional<sheet400_13DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_13 where code=?", nativeQuery = true)
    sheet400_13DAO findColumnsByCode(String code);
}
