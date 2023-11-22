package com.efass.memo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfassMemoRepository extends CrudRepository<EfassMemo, Integer> {
}
