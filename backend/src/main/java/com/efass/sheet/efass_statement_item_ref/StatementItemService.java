package com.efass.sheet.efass_statement_item_ref;

import com.efass.sheet.efass_statement_item_ref.dto.StatementItemRefRequest;
import com.efass.sheet.efass_statement_item_ref.dto.StatementItemRefResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class StatementItemService {


    private final StatementItemRepository itemRepository;

    public StatementItemRefApiResponse<Object> getAllStatementItem() {
        return StatementItemRefApiResponse.builder()
                .responseMessage("SUCCESS")
                .data(itemRepository.findAll())
                .build();
    }
    public StatementItemRefApiResponse<Object> createStatementItemRef(StatementItemRefRequest statementItemRefRequest) {
        StatementItemRefResponse response;
        StatementItemRef statementItem = validateStatementItemRef( statementItemRefRequest.getItemCode(),statementItemRefRequest.getStatementCode());
        if (statementItem == null) {
            statementItem = new StatementItemRef();
            statementItem.setStatementCode(statementItemRefRequest.getStatementCode());
            statementItem.setItemCode(statementItemRefRequest.getItemCode());
            statementItem.setItemDescription(statementItemRefRequest.getItemDescription());
            statementItem.setCreateDt(LocalDateTime.now());
            log.info(statementItem);
            itemRepository.save(statementItem);
            response = mapResponseToStatementRefResponse(statementItem);
        }
        else {
            throw new RuntimeException("Data already exist on database: You can run statement update");
        }
        return StatementItemRefApiResponse.builder()
                .data(response)
                .responseMessage("Record Added Successfully")
                .build();
    }
    public StatementItemRefApiResponse<Object> updateItemStatementRef(StatementItemRefRequest itemRequest) {
        StatementItemRef existingStatementItemRef =  validateStatementItemRef(itemRequest.getStatementCode(),itemRequest.getItemCode());
        if (existingStatementItemRef != null) {
            existingStatementItemRef.setItemDescription(itemRequest.getItemDescription());
            existingStatementItemRef.setStatementCode(itemRequest.getStatementCode());
            existingStatementItemRef.setItemCode(itemRequest.getItemCode());
            itemRepository.save(existingStatementItemRef);
        }
        assert existingStatementItemRef != null;
        return StatementItemRefApiResponse.builder()
                .responseMessage("Record Updated Successfully")
                .data(mapResponseToStatementRefResponse(existingStatementItemRef))
                .build();
    }

    public void deleteByStatementCode(String statementCode) {
        itemRepository.deleteByStatementCode(statementCode);
    }

    public void deleteByItemCode(String itemCode) {
        itemRepository.deleteByItemCode(itemCode);
    }

    private StatementItemRef validateStatementItemRef(String itemCode, String statementCode) {
        return itemRepository.findByItemCodeAndStatementCode(itemCode,statementCode).orElse(null);
    }

    private StatementItemRefResponse mapResponseToStatementRefResponse(StatementItemRef statementItemRef) {
        return StatementItemRefResponse.builder()
                .itemDescription(statementItemRef.getItemDescription())
                .itemCode(statementItemRef.getItemCode())
                .statementCode(statementItemRef.getItemDescription())
                .build();
    }
}
