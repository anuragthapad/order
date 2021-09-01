package com.rvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvy.entity.OrderDetail;

public interface OrderDetailRepository
	extends JpaRepository<OrderDetail, Integer> {
}
