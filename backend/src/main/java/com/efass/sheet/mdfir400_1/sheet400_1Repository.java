package com.efass.sheet.mdfir400_1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_1Repository extends CrudRepository<sheet400_1DAO, Integer> {
    Optional<sheet400_1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_1 where code=?", nativeQuery = true)
    Optional<sheet400_1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_1 where code=?", nativeQuery = true)
    sheet400_1DAO findColumnsByCode(String code);
}
