package com.efass.sheet.mdfir292_3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet292_3Repository extends CrudRepository<sheet292_3DAO, Integer> {
    Optional<sheet292_3DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR292_3 where code=?", nativeQuery = true)
    Optional<sheet292_3DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR292_3 where code=?", nativeQuery = true)
    sheet292_3DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.MDFIR292_3", nativeQuery = true)
    int getid();
}
