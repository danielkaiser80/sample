package com.efass.sheet.mdfir191;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sheet191Repository extends CrudRepository<sheet191DAO, Integer>{



	@Query(value = "select * from BOIEFASS.MDFIR191 where DURATION=? order by CREATE_DT ", nativeQuery = true)
	ArrayList<sheet191DAO> findByDuration(String duration);

	Optional<sheet191DAO> findById(int id);
	@Query(value = "select * from BOIEFASS.MDFIR191 where code=?", nativeQuery = true)
	ArrayList<sheet191DAO> findByCode(String code);

}
