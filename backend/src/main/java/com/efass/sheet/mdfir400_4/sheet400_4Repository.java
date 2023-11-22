package com.efass.sheet.mdfir400_4;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_4Repository extends CrudRepository<sheet400_4DAO, Integer> {
    Optional<sheet400_4DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_4 where code=?", nativeQuery = true)
    Optional<sheet400_4DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_4 where code=?", nativeQuery = true)
    sheet400_4DAO findColumnsByCode(String code);
}
