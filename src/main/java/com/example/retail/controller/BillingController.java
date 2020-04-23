package com.example.retail.controller;

import com.example.retail.enums.CustomerType;
import com.example.retail.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    BillingService billingService;

    @RequestMapping(value = "/{amount}/{customerType}", method = RequestMethod.GET)
    private BigDecimal getDiscount(@PathVariable BigDecimal amount, @PathVariable  CustomerType customerType){
        return billingService.getBillingAmount(amount,customerType);
    }

    @RequestMapping(method = RequestMethod.GET)
    private String test(){
        return "Working";
    }
}
