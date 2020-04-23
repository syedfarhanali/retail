package com.example.retail.service;

import com.example.retail.dao.DiscountSlabDao;
import com.example.retail.entity.DiscountSlab;
import com.example.retail.enums.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class DiscountService {

    @Autowired
    DiscountSlabDao discountSlabDao;

    public BigDecimal getDiscount(BigDecimal amount, CustomerType customerType){
       List<DiscountSlab> discountSlabList = discountSlabDao.findByCustomerType(customerType);
       BigDecimal totalDiscount = discountSlabList.stream().parallel()
               .filter(discountSlab -> discountSlab.getDiscount().compareTo(BigDecimal.ZERO) > 0)
               .map( discountSlab -> getSlabDiscount(amount,discountSlab) )
               .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalDiscount;
    }

    private BigDecimal getSlabDiscount(BigDecimal amount, DiscountSlab discountSlab){

        if(amount.compareTo(discountSlab.getStartRange()) <= 0){
            return BigDecimal.ZERO;
        }else if(Objects.isNull(discountSlab.getEndRange()) || amount.compareTo(discountSlab.getEndRange()) <= 0){
            return applyDiscount(amount.subtract(discountSlab.getStartRange()),discountSlab);
        }else if(amount.compareTo(discountSlab.getEndRange()) == 1){
            return applyDiscount(discountSlab.getEndRange().subtract(discountSlab.getStartRange()),discountSlab);
        }else {
            return BigDecimal.ZERO;
        }
    }

    private BigDecimal applyDiscount(BigDecimal amount,DiscountSlab discountSlab){
        return amount.multiply(discountSlab.getDiscount().divide(new BigDecimal(100)));
    }
}
