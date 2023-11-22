package com.efass.sheet.mdfir1600;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet1600Repository extends CrudRepository<sheet1600DAO, Integer> {
    Optional<sheet1600DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1600 where code=?", nativeQuery = true)
    Optional<sheet1600DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1600 where code=?", nativeQuery = true)
    sheet1600DAO findColumnsByCode(String code);
}
