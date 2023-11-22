package com.efass.sheet.mdfir600;

import com.efass.sheet.mdfir300.sheet300DAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Repository
public interface sheet600Repository extends CrudRepository<sheet600DAO, Integer> {

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR600 where code=?", nativeQuery = true)
    Optional<sheet600DAO> findByCode(String code);


    @Query(value = "SELECT * FROM BOIEFASS.MDFIR600 where code=?", nativeQuery = true)
    sheet600DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR600 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheet600DAO> findAllOrderByCode();
}
