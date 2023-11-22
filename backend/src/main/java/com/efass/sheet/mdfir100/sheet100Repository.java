package com.efass.sheet.mdfir100;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface sheet100Repository extends CrudRepository<sheet100DAO, Integer>{

    Optional<sheet100DAO> findById(int id);

//    @Query(value = "SELECT * FROM BOIEFASS.MDFIR100 where code=?", nativeQuery = true)
    Optional<sheet100DAO> findByCode(String code);

//    sheet100DAO findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR100 where code=?", nativeQuery = true)
    Optional<List<sheet100DAO>> findListOfCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR100 where code=?", nativeQuery = true)
    sheetQdfirDAO findColumnsByCode(String code);

    @Query(value = "SELECT PARAM_VALUE FROM BOIEFASS.CONTROL_PARAMETER WHERE PARAM_CD = 'EF01'", nativeQuery = true)
    String findCbdCode(String code);

    @Modifying
    @Query(value = "UPDATE BOIEFASS.CONTROL_PARAMETER cp SET cp.PARAM_VALUE =:cbnDate WHERE cp.PARAM_CD = 'EF01'", nativeQuery = true)
    void insertCBNdate (@Param("cbnDate") String cbnDate);

}



