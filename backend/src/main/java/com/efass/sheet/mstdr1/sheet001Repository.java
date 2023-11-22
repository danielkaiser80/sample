package com.efass.sheet.mstdr1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface sheet001Repository extends JpaRepository<sheet001DAO, Integer> {
    Optional<sheet001DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MSTDR1 where state_code=?", nativeQuery = true)
    Optional<sheet001DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MSTDR1 where state_code=?", nativeQuery = true)
    sheet001DAO findColumnsByCode(String code);
}
