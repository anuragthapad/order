package com.rvy.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.rvy.SupermarketAppOrderManagementServiceApplication;
import com.rvy.entity.OrderMaster;
import com.rvy.repository.OrderMasterRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SupermarketAppOrderManagementServiceApplication.class })

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class OrderMasterRepositoryIntegrationTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
	

	@Test
	public void checkingIds() {
		
		OrderMaster order = new OrderMaster(null,
				1,LocalDate.of(2000, 12, 23),225.01,56.56,null, 456.23,"UPI","INR",122,123, null);
		
		entityManager.persistAndFlush(order);
		
		OrderMaster orderFromDb = orderMasterRepository.findById(order.getOrderId()).get();
		assertThat(orderFromDb).isEqualTo(order);
	}
	
	@Test
	public void whenFindByPaymentMode_thenReturnPaymentMode() {
		OrderMaster order = new OrderMaster(null,
				1,LocalDate.of(2000, 12, 23),225.01,56.56,null, 456.23,"UPI","INR",122,123, null);
		entityManager.persistAndFlush(order);
		List<OrderMaster> orderList = orderMasterRepository.findByPaymentMode(order.getPaymentMode());
		if(orderList.size()!=0) {
        	assertThat(orderList.get(0).getPaymentMode()).isEqualTo(order.getPaymentMode());
        }else {
        	assertThat(orderList.get(0).getPaymentMode()).isNotEqualTo(order.getPaymentMode());
        }
	}
	
	@Test
	public void whenFindByInvalidPaymentMode_thenReturnNull() {
		OrderMaster order = new OrderMaster(null,
				1,LocalDate.of(2000, 12, 23),225.01,56.56,null, 456.23,"UPI","INR",122,123, null);
		entityManager.persistAndFlush(order);
		
		List<OrderMaster> orders = orderMasterRepository.findByPaymentMode("DEBITCARD");
		assertThat(orders).isEmpty();
	}
	
	@Test
	public void whenFindByCurrencyType_thenReturnCurrencyType() {
		OrderMaster order = new OrderMaster(null,
				1,LocalDate.of(2000, 12, 23),225.01,56.56,null, 456.23,"UPI","INR",122,123, null);
		entityManager.persistAndFlush(order);
		
		List<OrderMaster> orderList = orderMasterRepository.findByCurrencyType("INR");
		
		if(orderList.size()!=0) {
        	assertThat(orderList.get(0).getCurrencyType()).isEqualTo(order.getCurrencyType());
        }else {
        	assertThat(orderList.get(0).getCurrencyType()).isNotEqualTo(order.getCurrencyType());
        }
	}
	
	@Test
	public void whenFindByInvalidCurrencyType_thenReturnNull() {
		OrderMaster order = new OrderMaster(null,
				1,LocalDate.of(2000, 12, 23),225.01,56.56,null, 456.23,"UPI","INR",122,123, null);
		entityManager.persistAndFlush(order);
		List<OrderMaster> orders = orderMasterRepository.findByCurrencyType("USD");
		assertThat(orders).isEmpty();
	}

}
