package com.efass.sheet.mdfir292_1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheet292_1Repository extends CrudRepository<sheet292_1DAO, Integer> {
    Optional<sheet292_1DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR292_1 where code=?", nativeQuery = true)
    Optional<sheet292_1DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR292_1 where code=?", nativeQuery = true)
    sheet292_1DAO findColumnsByCode(String code);

    @Query(value = "SELECT count(*) FROM BOIEFASS.MDFIR292_1", nativeQuery = true)
    int getid();
}
