package com.efass.sheet.efass_custom_data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EfassCustomRepository extends JpaRepository<EfassCustomData,String> {
    EfassCustomData findByRefCd(String refCd);
}
