package com.efass.sheet.mdfir302;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface sheet302Repository extends JpaRepository<sheet302DAO, Integer> {

    Optional<sheet302DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR302 where code=?", nativeQuery = true)
    Optional<sheet302DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR302 where code=?", nativeQuery = true)
    sheet302DAO findColumnsByCode(String code);

}
