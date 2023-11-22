package com.efass.bank;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfassBankMapRepository extends CrudRepository<EfassBankMap, Integer> {


}
