package com.efass.sheet.efass_custom_data;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/efassCustomData")
@RequiredArgsConstructor
public class EfassCustomDataController {
    private final EfassCustomDataService service;

    @PutMapping("/{refCd}")
    @ResponseStatus(HttpStatus.OK)
    public EfassCustomDataApiResponse updateData(@PathVariable String refCd,
                                        @RequestParam String newRefDesc,
                                        @RequestParam String newRefType,
                                        @RequestParam String newRefValue) {
        return service.updateEfassCustomData(refCd, newRefDesc, newRefType, newRefValue);
    }
}
