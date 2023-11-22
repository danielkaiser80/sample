package com.efass.sheet.mcfpr1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface sheetQcfpr1Repository extends CrudRepository<sheetQcfpr1Dao, Integer> {
    Optional<sheetQcfpr1Dao> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.QCFPR1 where code=?", nativeQuery = true)
    Optional<sheetQcfpr1Dao> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.QCFPR1 where code=?", nativeQuery = true)
    sheetQcfpr1Dao findColumnsByCode(String code);
}
