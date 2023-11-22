package com.efass.sheet.mdfir142;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet142Repository extends CrudRepository<sheet142DAO, Integer> {
    Optional<sheet142DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR142 where code=?", nativeQuery = true)
    Optional<sheet142DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR142 where code=?", nativeQuery = true)
    sheet142DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.QDFIR142", nativeQuery = true)
    int getid();
}
