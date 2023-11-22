package com.efass.sheet.mdfir1000;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
@Repository
public interface sheet1000Repository extends CrudRepository<sheet1000DAO, Integer>{


@Query(value = "SELECT * FROM BOIEFASS.MDFIR1000 where code=?", nativeQuery = true)
	Optional<sheet1000DAO> findByCode(String code);

@Query(value = "SELECT * FROM BOIEFASS.MDFIR1000 where code=?", nativeQuery = true)
	sheet1000DAO findColumnsByCode(String code);

}



