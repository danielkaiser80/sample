package com.efass.sheet.mdfir371_1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet371_1Repository extends CrudRepository<sheet371_1DAO, Integer> {
    Optional<sheet371_1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR371_1 where code=?", nativeQuery = true)
    Optional<sheet371_1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR371_1 where code=?", nativeQuery = true)
    sheet371_1DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.MDFIR371_1", nativeQuery = true)
    int getid();
}
