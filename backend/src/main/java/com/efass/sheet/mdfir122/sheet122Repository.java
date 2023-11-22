package com.efass.sheet.mdfir122;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet122Repository extends CrudRepository<sheet122DAO, Integer> {
    Optional<sheet122DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR122 where code=?", nativeQuery = true)
    Optional<sheet122DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR122 where code=?", nativeQuery = true)
    sheet122DAO findColumnsByCode(String code);
}
