package com.efass.sheet.mdfir1500;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet1500Repository extends CrudRepository<sheet1500DAO, Integer> {
    Optional<sheet1500DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1500 where code=?", nativeQuery = true)
    Optional<sheet1500DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1500 where code=?", nativeQuery = true)
    sheet1500DAO findColumnsByCode(String code);
}
