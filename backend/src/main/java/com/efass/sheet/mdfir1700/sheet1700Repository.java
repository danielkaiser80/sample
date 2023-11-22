package com.efass.sheet.mdfir1700;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet1700Repository extends CrudRepository<sheet1700DAO, Integer> {
    Optional<sheet1700DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1700 where code=?", nativeQuery = true)
    Optional<sheet1700DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1700 where code=?", nativeQuery = true)
    sheet1700DAO findColumnsByCode(String code);
}
