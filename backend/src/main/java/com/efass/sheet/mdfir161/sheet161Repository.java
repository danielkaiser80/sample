package com.efass.sheet.mdfir161;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet161Repository extends CrudRepository<sheet161DAO, Integer> {
    Optional<sheet161DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR161 where code=?", nativeQuery = true)
    Optional<sheet161DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR161 where code=?", nativeQuery = true)
    sheet161DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.MDFIR161", nativeQuery = true)
    int getid();
}
