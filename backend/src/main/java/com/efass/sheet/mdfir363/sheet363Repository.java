package com.efass.sheet.mdfir363;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet363Repository extends CrudRepository<sheet363DAO, Integer> {
    Optional<sheet363DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR363 where code=?", nativeQuery = true)
    Optional<sheet363DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR363 where code=?", nativeQuery = true)
    sheet363DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.MDFIR363", nativeQuery = true)
    int getid();
}
