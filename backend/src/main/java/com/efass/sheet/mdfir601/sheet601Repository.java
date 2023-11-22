package com.efass.sheet.mdfir601;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet601Repository extends CrudRepository<sheet601DAO, Integer> {
    Optional<sheet601DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR601 where code=?", nativeQuery = true)
    Optional<sheet601DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR601 where code=?", nativeQuery = true)
    sheet601DAO findColumnsByCode(String code);
}
