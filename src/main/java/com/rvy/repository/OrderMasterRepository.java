package com.rvy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvy.entity.OrderMaster;

public interface OrderMasterRepository
	extends JpaRepository<OrderMaster, Integer> {
	List<OrderMaster> findByPaymentMode(String paymentMode);
	List<OrderMaster> findByCurrencyType(String currencyType);
}
