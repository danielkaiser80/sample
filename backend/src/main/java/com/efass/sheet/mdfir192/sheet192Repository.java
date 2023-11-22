package com.efass.sheet.mdfir192;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.efass.sheet.mdfir191.sheet191DAO;

@Repository
public interface sheet192Repository extends CrudRepository<sheet192DAO, Integer>{



	@Query(value = "select * from BOIEFASS.MDFIR192 where DURATION=? order by CREATE_DT ", nativeQuery = true)
	ArrayList<sheet192DAO> findByDuration(String duration);

	Optional<sheet192DAO> findById(int id);
	@Query(value = "select * from BOIEFASS.MDFIR192 where code=?", nativeQuery = true)
	ArrayList<sheet191DAO> findByCode(String code);


}
