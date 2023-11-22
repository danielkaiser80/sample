package com.efass.bank;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EfassBankDto {

    private Integer id;
    @NonNull
    private String institutionCode;
    @NonNull
    private String institutionName;
    @NonNull
    private String accountNumber;
    @NonNull
    private String glCode;
}
