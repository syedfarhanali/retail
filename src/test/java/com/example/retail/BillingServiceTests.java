package com.example.retail;


import com.example.retail.enums.CustomerType;
import com.example.retail.service.BillingService;
import com.example.retail.service.DiscountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class BillingServiceTests {

    @Autowired
    BillingService billingService;

    @MockBean
    DiscountService discountService;

    @Test
    public void whenAmountIsZero(){
        Mockito.when(discountService.getDiscount(BigDecimal.ZERO, CustomerType.Premium)).thenReturn(BigDecimal.ZERO);
        BigDecimal billingAmount = billingService.getBillingAmount(BigDecimal.ZERO,CustomerType.Premium);
        Assert.assertEquals(BigDecimal.ZERO, billingAmount);
    }

    @Test
    public void verifyInvocation(){
        BigDecimal amount = new BigDecimal(10000);
        Mockito.when(discountService.getDiscount(amount, CustomerType.Regular)).thenReturn(new BigDecimal(500));
        BigDecimal billingAmount = billingService.getBillingAmount(amount,CustomerType.Regular);
        Mockito.verify(discountService,Mockito.times(1)).getDiscount(amount,CustomerType.Regular);
    }

    @Test
    public void verifyBillingAmount(){
        BigDecimal amount = new BigDecimal(4000);
        Mockito.when(discountService.getDiscount(amount, CustomerType.Premium)).thenReturn(new BigDecimal(400));
        BigDecimal billingAmount = billingService.getBillingAmount(amount,CustomerType.Premium);
        Assert.assertEquals(0,billingAmount.compareTo(new BigDecimal(3600)));
    }



}
