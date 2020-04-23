package com.example.retail.dao;

import com.example.retail.entity.DiscountSlab;
import com.example.retail.enums.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscountSlabDao extends JpaRepository<DiscountSlab, Long> {

    List<DiscountSlab> findByCustomerType(CustomerType customerType);
}
