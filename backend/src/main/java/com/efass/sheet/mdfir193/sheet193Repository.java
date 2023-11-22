package com.efass.sheet.mdfir193;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet193Repository extends CrudRepository<sheet193DAO, Integer> {
    Optional<sheet193DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR193 where code=?", nativeQuery = true)
    Optional<sheet193DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR193 where code=?", nativeQuery = true)
    sheet193DAO findColumnsByCode(String code);
}
