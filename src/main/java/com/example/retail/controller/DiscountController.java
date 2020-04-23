package com.example.retail.controller;

import com.example.retail.enums.CustomerType;
import com.example.retail.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping("/{amount}/{customerType}")
    private BigDecimal getDiscount(BigDecimal amount, CustomerType customerType){
        return discountService.getDiscount(amount,customerType);
    }


}
