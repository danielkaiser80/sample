package com.efass.sheet.mdfir700;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Repository
public interface sheet700Repository extends CrudRepository<sheet700DAO, Integer> {
    @Query(value = "SELECT * FROM BOIEFASS.MDFIR700 where code=?", nativeQuery = true)
    Optional<sheet700DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR700 where code=?", nativeQuery = true)
    sheet700DAO findColumnsByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR600 ORDER BY CODE ASC", nativeQuery = true)
    ArrayList<sheet700DAO> findAllOrderByCode();

}
