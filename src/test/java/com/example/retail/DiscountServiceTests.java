package com.example.retail;

import com.example.retail.dao.DiscountSlabDao;
import com.example.retail.entity.DiscountSlab;
import com.example.retail.enums.CustomerType;
import com.example.retail.service.BillingService;
import com.example.retail.service.DiscountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class DiscountServiceTests {

    @Autowired
    DiscountService discountService;

    @MockBean
    DiscountSlabDao discountSlabDao;

    @Test
    public void verifyInvocations(){
        BigDecimal amount = new BigDecimal(3000);
        DiscountSlab discountSlab1 = new DiscountSlab(CustomerType.Regular,new BigDecimal(500),new BigDecimal(100),new BigDecimal(10));
        DiscountSlab discountSlab2 = new DiscountSlab(CustomerType.Regular,new BigDecimal(1000),new BigDecimal(2000),new BigDecimal(20));
        List<DiscountSlab> list = new ArrayList<DiscountSlab>(Arrays.asList(new DiscountSlab[]{discountSlab1,discountSlab2}));

        Mockito.when(discountSlabDao.findByCustomerType(CustomerType.Regular)).thenReturn(list);
        BigDecimal billingAmount = discountService.getDiscount(amount,CustomerType.Regular);
        Mockito.verify(discountSlabDao,Mockito.times(1)).findByCustomerType(CustomerType.Regular);
    }


    @Test
    public void verifyCalculations1(){
        BigDecimal amount = new BigDecimal(0);
        DiscountSlab discountSlab1 = new DiscountSlab(CustomerType.Regular,new BigDecimal(500),new BigDecimal(1000),new BigDecimal(10));
        DiscountSlab discountSlab2 = new DiscountSlab(CustomerType.Regular,new BigDecimal(1000),new BigDecimal(2000),new BigDecimal(20));
        List<DiscountSlab> list = new ArrayList<DiscountSlab>(Arrays.asList(new DiscountSlab[]{discountSlab1,discountSlab2}));
        Mockito.when(discountSlabDao.findByCustomerType(CustomerType.Regular)).thenReturn(list);
        BigDecimal discount = discountService.getDiscount(amount,CustomerType.Regular);
        Assert.assertEquals(0,discount.compareTo(new BigDecimal(0)));
    }


    @Test
    public void verifyCalculations2(){
        BigDecimal amount = new BigDecimal(499);
        DiscountSlab discountSlab1 = new DiscountSlab(CustomerType.Regular,new BigDecimal(500),new BigDecimal(1000),new BigDecimal(10));
        DiscountSlab discountSlab2 = new DiscountSlab(CustomerType.Regular,new BigDecimal(1000),new BigDecimal(2000),new BigDecimal(20));
        List<DiscountSlab> list = new ArrayList<DiscountSlab>(Arrays.asList(new DiscountSlab[]{discountSlab1,discountSlab2}));
        Mockito.when(discountSlabDao.findByCustomerType(CustomerType.Regular)).thenReturn(list);
        BigDecimal discount = discountService.getDiscount(amount,CustomerType.Regular);
        Assert.assertEquals(0,discount.compareTo(new BigDecimal(0)));
    }

    @Test
    public void verifyCalculations3(){
        BigDecimal amount = new BigDecimal(500);
        DiscountSlab discountSlab1 = new DiscountSlab(CustomerType.Regular,new BigDecimal(500),new BigDecimal(1000),new BigDecimal(10));
        DiscountSlab discountSlab2 = new DiscountSlab(CustomerType.Regular,new BigDecimal(1000),new BigDecimal(2000),new BigDecimal(20));
        List<DiscountSlab> list = new ArrayList<DiscountSlab>(Arrays.asList(new DiscountSlab[]{discountSlab1,discountSlab2}));
        Mockito.when(discountSlabDao.findByCustomerType(CustomerType.Regular)).thenReturn(list);
        BigDecimal discount = discountService.getDiscount(amount,CustomerType.Regular);
        Assert.assertEquals(0,discount.compareTo(new BigDecimal(0)));
    }

    @Test
    public void verifyCalculations4(){
        BigDecimal amount = new BigDecimal(700);
        DiscountSlab discountSlab1 = new DiscountSlab(CustomerType.Regular,new BigDecimal(500),new BigDecimal(1000),new BigDecimal(10));
        DiscountSlab discountSlab2 = new DiscountSlab(CustomerType.Regular,new BigDecimal(1000),new BigDecimal(2000),new BigDecimal(20));
        List<DiscountSlab> list = new ArrayList<DiscountSlab>(Arrays.asList(new DiscountSlab[]{discountSlab1,discountSlab2}));
        Mockito.when(discountSlabDao.findByCustomerType(CustomerType.Regular)).thenReturn(list);
        BigDecimal discount = discountService.getDiscount(amount,CustomerType.Regular);
        Assert.assertEquals(0,discount.compareTo(new BigDecimal(20)));
    }

    @Test
    public void verifyCalculations5(){
        BigDecimal amount = new BigDecimal(1500);
        DiscountSlab discountSlab1 = new DiscountSlab(CustomerType.Regular,new BigDecimal(500),new BigDecimal(1000),new BigDecimal(10));
        DiscountSlab discountSlab2 = new DiscountSlab(CustomerType.Regular,new BigDecimal(1000),null,new BigDecimal(20));
        List<DiscountSlab> list = new ArrayList<DiscountSlab>(Arrays.asList(new DiscountSlab[]{discountSlab1,discountSlab2}));
        Mockito.when(discountSlabDao.findByCustomerType(CustomerType.Regular)).thenReturn(list);
        BigDecimal discount = discountService.getDiscount(amount,CustomerType.Regular);
        Assert.assertEquals(0,discount.compareTo(new BigDecimal(150)));
    }

    @Test
    public void verifyCalculations6(){
        BigDecimal amount = new BigDecimal(2000);
        DiscountSlab discountSlab1 = new DiscountSlab(CustomerType.Regular,new BigDecimal(500),new BigDecimal(1000),new BigDecimal(10));
        DiscountSlab discountSlab2 = new DiscountSlab(CustomerType.Regular,new BigDecimal(1000),null,new BigDecimal(20));
        List<DiscountSlab> list = new ArrayList<DiscountSlab>(Arrays.asList(new DiscountSlab[]{discountSlab1,discountSlab2}));
        Mockito.when(discountSlabDao.findByCustomerType(CustomerType.Regular)).thenReturn(list);
        BigDecimal discount = discountService.getDiscount(amount,CustomerType.Regular);
        Assert.assertEquals(0,discount.compareTo(new BigDecimal(250)));
    }

    @Test
    public void verifyCalculations7(){
        BigDecimal amount = new BigDecimal(3000);
        DiscountSlab discountSlab1 = new DiscountSlab(CustomerType.Regular,new BigDecimal(500),new BigDecimal(1000),new BigDecimal(10));
        DiscountSlab discountSlab2 = new DiscountSlab(CustomerType.Regular,new BigDecimal(1000),new BigDecimal(2000),new BigDecimal(20));
        List<DiscountSlab> list = new ArrayList<DiscountSlab>(Arrays.asList(new DiscountSlab[]{discountSlab1,discountSlab2}));
        Mockito.when(discountSlabDao.findByCustomerType(CustomerType.Regular)).thenReturn(list);
        BigDecimal discount = discountService.getDiscount(amount,CustomerType.Regular);
        Assert.assertEquals(0,discount.compareTo(new BigDecimal(250)));
    }

}
