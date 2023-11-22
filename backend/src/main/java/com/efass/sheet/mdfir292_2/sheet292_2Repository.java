package com.efass.sheet.mdfir292_2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet292_2Repository extends CrudRepository<sheet292_2DAO, Integer> {
    Optional<sheet292_2DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR292_2 where code=?", nativeQuery = true)
    Optional<sheet292_2DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR292_2 where code=?", nativeQuery = true)
    sheet292_2DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.MDFIR292_2", nativeQuery = true)
    int getid();
}
