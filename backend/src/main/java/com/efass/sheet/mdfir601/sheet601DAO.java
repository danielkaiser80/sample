package com.efass.sheet.mdfir601;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "MDFIR601")
public class sheet601DAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    public Integer id;

    @Column(name = "CUSTOMER_NAME")
    public String customer_name;

    @Column(name = "DATE_APPROVED")
    public LocalDate date_approved;

    @Column(name = "FOREIGN_CURRENCY")
    public String foreign_currency;

    @Column(name = "RATE_OF_EXCHANGE")
    public BigDecimal rate_of_exchange;

    @Column(name = "APPROVED_LIMIT")
    public BigDecimal approved_limit;

    @Column(name = "AMOUNT_DRAWN")
    public BigDecimal amount_drawn;
    @Column(name = "CREATE_DT")
    public Date create_dt;


    @PrePersist
    protected void onCreate() {
        create_dt = new Date();
    }
}
