package com.efass.bank;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("api/v1/bank")
@RestController
@RequiredArgsConstructor
public class EfassBankMapController {
    private final EfassBankMapService efassBankMapService;
    @PutMapping
    public ResponseEntity<EfassBankDto> edit(@Valid @RequestBody EfassBankDto data) {
        data = efassBankMapService.edit(data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EfassBankDto> add(@Valid @RequestBody EfassBankDto data) {
        data = efassBankMapService.add(data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam @NonNull Integer id) {
        efassBankMapService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("all")
    public ResponseEntity<Iterable<EfassBankMap>> getAll() {
        Iterable<EfassBankMap> data = efassBankMapService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<EfassBankMap> get(@RequestParam @NonNull Integer id) {
        EfassBankMap data = efassBankMapService.getOne(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
