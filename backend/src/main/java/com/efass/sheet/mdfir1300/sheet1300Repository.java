package com.efass.sheet.mdfir1300;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet1300Repository extends CrudRepository<sheet1300DAO, Integer> {
    Optional<sheet1300DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1300 where code=?", nativeQuery = true)
    Optional<sheet1300DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1300 where code=?", nativeQuery = true)
    sheet1300DAO findColumnsByCode(String code);
}
