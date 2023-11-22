package com.efass.sheet.mdfir400_3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_3Repository extends CrudRepository<sheet400_3DAO, Integer> {
    Optional<sheet400_3DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_3 where code=?", nativeQuery = true)
    Optional<sheet400_3DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_3 where code=?", nativeQuery = true)
    sheet400_3DAO findColumnsByCode(String code);
}
