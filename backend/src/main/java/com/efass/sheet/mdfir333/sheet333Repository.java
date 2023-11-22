package com.efass.sheet.mdfir333;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet333Repository extends CrudRepository<sheet333DAO, Integer> {
    Optional<sheet333DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR333 where code=?", nativeQuery = true)
    Optional<sheet333DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR333 where code=?", nativeQuery = true)
    sheet333DAO findColumnsByCode(String code);
}
