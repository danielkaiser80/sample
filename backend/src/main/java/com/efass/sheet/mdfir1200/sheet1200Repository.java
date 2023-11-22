package com.efass.sheet.mdfir1200;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface sheet1200Repository extends JpaRepository<sheet1200DAO, Integer>
{
    Optional<sheet1200DAO> findById(int id);
    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1200 where code=?", nativeQuery = true)
    Optional<sheet1200DAO> findByCode(String code);


    @Query(value = "SELECT * FROM BOIEFASS.MDFIR1200 where code=?", nativeQuery = true)
    sheet1200DAO findColumnsByCode(String code);
}
