package com.efass.sheet.mdfir1400;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet1400Repository extends CrudRepository<sheet1400DAO, Integer> {
    Optional<sheet1400DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1400 where code=?", nativeQuery = true)
    Optional<sheet1400DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1400 where code=?", nativeQuery = true)
    sheet1400DAO findColumnsByCode(String code);
}
