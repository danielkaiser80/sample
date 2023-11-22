package com.efass.sheet.mdfir400_11;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_11Repository extends CrudRepository<sheet400_11DAO, Integer> {
    Optional<sheet400_11DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_11 where code=?", nativeQuery = true)
    Optional<sheet400_11DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_11 where code=?", nativeQuery = true)
    sheet400_11DAO findColumnsByCode(String code);
}
