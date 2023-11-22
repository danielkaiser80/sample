package com.efass.sheet.mdfir371_2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet371_2Repository extends CrudRepository<sheet371_2DAO, Integer> {
    Optional<sheet371_2DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR371_2 where code=?", nativeQuery = true)
    Optional<sheet371_2DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR371_2 where code=?", nativeQuery = true)
    sheet371_2DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.MDFIR371_2", nativeQuery = true)
    int getid();
}
