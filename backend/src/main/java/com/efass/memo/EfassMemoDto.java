package com.efass.memo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EfassMemoDto {

    public Integer id;

    public String gl_code;

    public String gl_description;

    public String dr_cr_ind;

    public Integer amount;

    public String period;

    public String year;

    public String posting_ind;

    public String status;

    public Integer crncy_id;

    public String crncy_cd_iso;
}
