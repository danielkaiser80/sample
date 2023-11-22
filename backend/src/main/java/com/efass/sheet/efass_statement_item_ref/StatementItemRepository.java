package com.efass.sheet.efass_statement_item_ref;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatementItemRepository extends JpaRepository<StatementItemRef,Integer> {
    StatementItemRef findByStatementCode(String statementCode);

    StatementItemRef findByItemCode(String itemCode);

    void deleteByStatementCode(String statementCode);

    void deleteByItemCode(String itemCode);

    Optional<StatementItemRef> findByItemCodeAndStatementCode(String itemCode,String statementCode);
}
