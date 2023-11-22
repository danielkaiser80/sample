package com.efass.sheet.mdfir400_2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_2Repository extends CrudRepository<sheet400_2DAO, Integer> {
    Optional<sheet400_2DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_2 where code=?", nativeQuery = true)
    Optional<sheet400_2DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_2 where code=?", nativeQuery = true)
    sheet400_2DAO findColumnsByCode(String code);
}
