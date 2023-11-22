package com.efass.sheet.mdfir921;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface sheet921Repository extends CrudRepository<sheet921DAO, Integer> {

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR921 where code=?", nativeQuery = true)
    Optional<sheet921DAO>findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR921 where code=?", nativeQuery = true)
    sheet921DAO fingColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR921 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheet921DAO> findAllOrderByCode();


}
