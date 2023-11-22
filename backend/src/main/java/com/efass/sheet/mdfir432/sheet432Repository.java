package com.efass.sheet.mdfir432;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet432Repository extends CrudRepository<sheet432DAO, Integer> {
    Optional<sheet432DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR432 where code=?", nativeQuery = true)
    Optional<sheet432DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR432 where code=?", nativeQuery = true)
    sheet432DAO findColumnsByCode(String code);
}
