package com.efass.sheet.mdfir302;



import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "MDFIR302")
public class sheet302DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ITEM_CODE")
    public String code;
    @Column(name = "ITEM_DESCRIPTION")
    public String item_description;
    @Column(name = "AMOUNT")
    public BigDecimal amount;

    public sheet302DAO() {

    }

    public sheet302DAO(Integer id, String code, String item_description,  BigDecimal amount) {
        super();
        this.id = id;
        this.code = code;
        this.item_description = item_description;
        this.amount = amount;

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getItem_description() {
        return item_description;
    }
    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
