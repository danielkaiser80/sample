package com.efass.sheet.mdfir172;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet172Repository extends CrudRepository<sheet172DAO, Integer> {
    Optional<sheet172DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR172 where code=?", nativeQuery = true)
    Optional<sheet172DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR172 where code=?", nativeQuery = true)
    sheet172DAO findColumnsByCode(String code);
}
