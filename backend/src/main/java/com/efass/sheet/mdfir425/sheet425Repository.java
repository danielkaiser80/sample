package com.efass.sheet.mdfir425;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet425Repository extends CrudRepository<sheet425DAO, Integer> {
    Optional<sheet425DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR425 where code=?", nativeQuery = true)
    Optional<sheet425DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR425 where code=?", nativeQuery = true)
    sheet425DAO findColumnsByCode(String code);
}
