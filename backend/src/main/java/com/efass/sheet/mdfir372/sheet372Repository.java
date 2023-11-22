package com.efass.sheet.mdfir372;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface sheet372Repository extends CrudRepository<sheet372DAO, Integer>{

	Optional<sheet372DAO> findById(int id);
    @Query(value = "SELECT * FROM BOIEFASS.MDFIR372 where code=?", nativeQuery = true)
    Optional<sheet372DAO> findByCode(String code);


    @Query(value = "SELECT * FROM BOIEFASS.MDFIR372 where code=?", nativeQuery = true)
    sheet372DAO findColumnsByCode(String code);
}

