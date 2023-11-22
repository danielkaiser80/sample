package com.efass.sheet.mdfir920;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface sheet920Repository extends CrudRepository<sheet920DAO, Integer> {

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR920 where code=?", nativeQuery = true)
    Optional<sheet920DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR920 where code=?", nativeQuery = true)
    sheet920DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR920 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheet920DAO> findAllOrderByCode();

}
