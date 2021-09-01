package com.rvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvy.entity.DiscountMaster;

public interface DiscountMasterRepository
	extends JpaRepository<DiscountMaster, Integer> {}
