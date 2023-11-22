package com.efass.sheet.mdfir400_6;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_6Repository extends CrudRepository<sheet400_6DAO, Integer> {
    Optional<sheet400_6DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_6 where code=?", nativeQuery = true)
    Optional<sheet400_6DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_6 where code=?", nativeQuery = true)
    sheet400_6DAO findColumnsByCode(String code);
}
