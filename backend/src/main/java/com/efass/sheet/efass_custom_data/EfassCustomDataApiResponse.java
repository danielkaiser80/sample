package com.efass.sheet.efass_custom_data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EfassCustomDataApiResponse {
    private String responseMessage;
    private EfassCustomDataResponse efassCustomDataResponse;
}
