package com.efass.sheet.mdfir382;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface sheet382Repository extends CrudRepository<sheet382DAO, Integer>{

	Optional<sheet382DAO> findById(int id);
    @Query(value = "SELECT * FROM BOIEFASS.MDFIR382 where code=?", nativeQuery = true)
    Optional<sheet382DAO> findByCode(String code);


    @Query(value = "SELECT * FROM BOIEFASS.MDFIR382 where code=?", nativeQuery = true)
    sheet382DAO findColumnsByCode(String code);
}

