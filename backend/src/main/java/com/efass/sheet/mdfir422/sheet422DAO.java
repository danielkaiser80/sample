package com.efass.sheet.mdfir422;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MDFIR422")
public class sheet422DAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "ITEM_DESCRIPTION")
    public String description;

    @Column(name = "AMOUNT")
    public BigDecimal amount;
}
