package com.efass.sheet.mdfir400_15;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_15Repository extends CrudRepository<sheet400_15DAO, Integer> {
    Optional<sheet400_15DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_15 where code=?", nativeQuery = true)
    Optional<sheet400_15DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_15 where code=?", nativeQuery = true)
    sheet400_15DAO findColumnsByCode(String code);
}
