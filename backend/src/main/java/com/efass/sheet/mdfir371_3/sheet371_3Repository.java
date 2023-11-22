package com.efass.sheet.mdfir371_3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet371_3Repository extends CrudRepository<sheet371_3DAO, Integer> {
    Optional<sheet371_3DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR371_3 where code=?", nativeQuery = true)
    Optional<sheet371_3DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR371_3 where code=?", nativeQuery = true)
    sheet371_3DAO findColumnsByCode(String code);
}
