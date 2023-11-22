package com.efass.sheet.mdfir223;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet223Repository extends CrudRepository<sheet223DAO, Integer> {
    Optional<sheet223DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR223 where code=?", nativeQuery = true)
    Optional<sheet223DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR223 where code=?", nativeQuery = true)
    sheet223DAO findColumnsByCode(String code);
}
