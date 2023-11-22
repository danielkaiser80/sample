package com.efass.sheet.mdfir800;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Repository
public interface sheet800Repository extends CrudRepository<sheet800DAO, Integer> {
    @Query(value = "SELECT * FROM BOIEFASS.MDFIR800 where code=?", nativeQuery = true)
    Optional<sheet800DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR800 where code=?", nativeQuery = true)
    sheet800DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR600 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheet800DAO> findAllOrderByCode();

}
