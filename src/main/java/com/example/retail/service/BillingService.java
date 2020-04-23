package com.example.retail.service;

import com.example.retail.enums.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BillingService {


    @Autowired
    DiscountService discountService;

    public BigDecimal getBillingAmount(BigDecimal amount, CustomerType customerType){

        BigDecimal discount = discountService.getDiscount(amount,customerType);

        return  amount.subtract(discount);
    }
}
