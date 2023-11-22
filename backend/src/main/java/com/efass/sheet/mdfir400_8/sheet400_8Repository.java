package com.efass.sheet.mdfir400_8;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_8Repository extends CrudRepository<sheet400_8DAO, Integer> {
    Optional<sheet400_8DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_8 where code=?", nativeQuery = true)
    Optional<sheet400_8DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_8 where code=?", nativeQuery = true)
    sheet400_8DAO findColumnsByCode(String code);
}
