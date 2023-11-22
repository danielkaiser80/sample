package com.efass.sheet.mdfir1301;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet1301Repository extends CrudRepository<sheet1301DAO, Integer> {
    Optional<sheet1301DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1301 where code=?", nativeQuery = true)
    Optional<sheet1301DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1301 where code=?", nativeQuery = true)
    sheet1301DAO findColumnsByCode(String code);
}
