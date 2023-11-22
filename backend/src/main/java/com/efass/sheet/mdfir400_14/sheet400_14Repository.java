package com.efass.sheet.mdfir400_14;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet400_14Repository extends CrudRepository<sheet400_14DAO, Integer> {
    Optional<sheet400_14DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_14 where code=?", nativeQuery = true)
    Optional<sheet400_14DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR400_14 where code=?", nativeQuery = true)
    sheet400_14DAO findColumnsByCode(String code);
}
