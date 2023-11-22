package com.efass.sheet.mdfir423;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface sheet423Repository extends CrudRepository<sheet423DAO, Integer> {

    Optional<sheet423DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR423 where code=?", nativeQuery = true)
    Optional<sheet423DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR423 where code=?", nativeQuery = true)
    sheet423DAO findColumnsByCode(String code);
}
