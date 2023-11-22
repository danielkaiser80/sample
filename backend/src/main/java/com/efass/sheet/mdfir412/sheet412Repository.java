package com.efass.sheet.mdfir412;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet412Repository extends CrudRepository<sheet412DAO, Integer> {
    Optional<sheet412DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR412 where code=?", nativeQuery = true)
    Optional<sheet412DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR412 where code=?", nativeQuery = true)
    sheet412DAO findColumnsByCode(String code);
}
