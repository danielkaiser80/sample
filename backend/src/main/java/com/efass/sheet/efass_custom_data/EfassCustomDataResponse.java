package com.efass.sheet.efass_custom_data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EfassCustomDataResponse {
   private String newRefDesc;
   private String newRefType;
   private String newRefValue;
}
