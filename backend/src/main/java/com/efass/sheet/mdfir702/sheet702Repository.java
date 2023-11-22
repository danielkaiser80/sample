package com.efass.sheet.mdfir702;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.sheet.mdfir300.sheet300DAO;

import java.util.ArrayList;
import java.util.Optional;
@Repository
public interface sheet702Repository extends CrudRepository<sheet702DAO, Integer> {
    Optional<sheet702DAO> findById(int id);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR702 where code=?", nativeQuery = true)
    Optional<sheet702DAO> findByCode(String code);

    @Query(value = "SELECT * FROM BOIEFASS.MDFIR702 where code=?", nativeQuery = true)
    sheet702DAO findColumnsByCode(String code);

	@Query(value = "SELECT * FROM BOIEFASS.MDFIR702 ORDER BY CODE ASC", nativeQuery = true)
		ArrayList<sheet702DAO> findAllOrderByCode();
}
