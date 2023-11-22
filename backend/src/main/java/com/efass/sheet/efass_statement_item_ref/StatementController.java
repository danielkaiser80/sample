package com.efass.sheet.efass_statement_item_ref;

import com.efass.sheet.efass_statement_item_ref.dto.StatementItemRefRequest;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/statementItemRef")
@RequiredArgsConstructor
public class StatementController {
    private final StatementItemService statementItemService;
    @PostMapping("createStatement")
    @ResponseStatus(HttpStatus.CREATED)
    public StatementItemRefApiResponse<Object>createStatement(@RequestBody StatementItemRefRequest refRequest) {
        return statementItemService.createStatementItemRef(refRequest);
    }

    @PostMapping("updateStatement")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StatementItemRefApiResponse<Object>updateStatement(@RequestBody StatementItemRefRequest refRequest) {
        return  statementItemService.updateItemStatementRef(refRequest);
    }

    @DeleteMapping("updateStatement/{statementCode}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByStatementCode(@PathVariable String statementCode) {
         statementItemService.deleteByStatementCode(statementCode);
    }

    @DeleteMapping("updateStatement/{itemCode}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByItemCode(@PathVariable String itemCode) {
         statementItemService.deleteByItemCode(itemCode);
    }

    @GetMapping("fetchAllItemRef")
    @ResponseStatus(HttpStatus.OK)
    public StatementItemRefApiResponse<Object> fetchAllItemRef() {
       return statementItemService.getAllStatementItem();
    }

}
