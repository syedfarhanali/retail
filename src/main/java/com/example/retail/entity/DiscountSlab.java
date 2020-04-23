package com.example.retail.entity;

import com.example.retail.enums.CustomerType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class DiscountSlab {

    @Id
    @GeneratedValue
    private int id;

    private CustomerType customerType;
    private BigDecimal startRange;
    private BigDecimal endRange;
    private BigDecimal discount;


    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public void setStartRange(BigDecimal startRange) {
        this.startRange = startRange;
    }

    public void setEndRange(BigDecimal endRange) {
        this.endRange = endRange;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public BigDecimal getStartRange() {
        return startRange;
    }

    public BigDecimal getEndRange() {
        return endRange;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public DiscountSlab(CustomerType customerType, BigDecimal startRange, BigDecimal endRange, BigDecimal discount) {
        this.customerType = customerType;
        this.startRange = startRange;
        this.endRange = endRange;
        this.discount = discount;
    }
}
