package com.efass.sheet.mstdr2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface sheet002Repository extends JpaRepository<sheet002DAO, Integer> {
    Optional<sheet002DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MSTDR2 where code=?", nativeQuery = true)
    Optional<sheet002DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MSTDR2 where state_code=?", nativeQuery = true)
    sheet002DAO findColumnsByCode(String code);
}
