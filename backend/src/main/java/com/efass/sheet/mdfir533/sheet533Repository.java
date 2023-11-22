package com.efass.sheet.mdfir533;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet533Repository extends CrudRepository<sheet533DAO, Integer> {
    Optional<sheet533DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR533 where code=?", nativeQuery = true)
    Optional<sheet533DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR533 where code=?", nativeQuery = true)
    sheet533DAO findColumnsByCode(String code);
}
