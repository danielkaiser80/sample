package com.efass.activity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlParameterRepo extends CrudRepository<ControlParameterDao, Integer> {
}
