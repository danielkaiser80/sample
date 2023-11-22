package com.efass.sheet.mdfir1650;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet1650Repository extends CrudRepository<sheet1650DAO, Integer> {
    Optional<sheet1650DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1650 where code=?", nativeQuery = true)
    Optional<sheet1650DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1650 where code=?", nativeQuery = true)
    sheet1650DAO findColumnsByCode(String code);
}
