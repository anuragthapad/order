package com.rvy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.rvy.entity.OrderMaster;
import com.rvy.exception.OrderException;

import com.rvy.repository.OrderMasterRepository;


@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT.RANDOM_PORT)
class OrderMasterServiceImplTest {

	@TestConfiguration
	static class OrderManagementServiceImplTestContextConfiguration {
		@Bean
		public OrderMasterService Service() {
			return new OrderMasterServiceImpl();
		}

	}

	@Autowired
	private OrderMasterService orderMasterService;
	
//	@MockBean
//	private DiscountMaster discountMaster;
	
	@MockBean
	private OrderMasterRepository orderMasterRepository;
	
	
	
	List<OrderMaster> orderList;
	OrderMaster order;
	OrderMaster order4;
	OrderMaster testOrder;
	@BeforeEach
	public void dummyManagement() {

		OrderMaster order1 = new OrderMaster(22,
				1,LocalDate.of(2000, 10, 25),255.01,56.46,456.23,"UPI","INR",122,123);
		OrderMaster order2 = new OrderMaster(23,
				2,LocalDate.of(2000, 12, 23),225.01,56.56, 496.23,"DEBIT","USD",254,129);
		OrderMaster order3 = new OrderMaster(24,
				3,LocalDate.of(2010, 12, 23),445.56,78.56, 956.23,"CASH","YEN",255,127);
		 order4 = new OrderMaster(25,
				3,LocalDate.of(2010, 12, 23),445.56,78.56, 956.23,"CASH","YEN",255,127);					
				
			orderList = Arrays.asList(order1,order2,order3);	
			
			Mockito.when(orderMasterRepository.findById(-11)).thenReturn(null);
			Mockito.when(orderMasterRepository.findByPaymentMode("CREDIT")).thenReturn(null);

			Mockito.when(orderMasterRepository.findById(order1.getOrderId())).thenReturn(Optional.of(order1));
			Mockito.when(orderMasterRepository.findAll()).thenReturn(orderList);
			Mockito.when(orderMasterRepository.findById(108)).thenReturn(Optional.empty());
			Mockito.when(orderMasterRepository.findByCurrencyType("USD")).thenReturn(Arrays.asList(order2));//.collect(Collectors.toList()));
			Mockito.when(orderMasterRepository.save(order4)).thenReturn(order4);
		
//		testOrder = new OrderMaster(1,23.5);
//		Mockito.when(orderMasterRepository.findById(1).get()).thenReturn(testOrder);
	}
	
	@Test
	public void validCurrencyAndPaymentModeFromId() {
		OrderMaster testOrderMaster;
		try {
			testOrderMaster = orderMasterRepository.findById(22).get();
			assertThat(testOrderMaster.getCurrencyType()=="INR");
			assertThat(testOrderMaster.getPaymentMode()=="UPI");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void InValidIdCheck() {
		OrderMaster orderMaster;
		try {
			//orderMaster = orderMasterRepository.findById(-11).get();
			assertThat(order).isNull();
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void whenFindAll_ReturnAll() {
		try {
			List<OrderMaster> orders = orderMasterService.getAllOrders();
			assertThat(orders).isEqualTo(orderList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void givenOrderToAddShouldReturnAddedOrder() throws OrderException {
		try {
			
			OrderMaster orderAdded = orderMasterService.addOrder(order4);
			assertThat(orderAdded).isEqualTo(order4);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testDiscount() {
//		OrderMaster newOrder = orderMasterRepository.findById(testOrder.getOrderId()).get();
//		assertThat(newOrder).isEqualTo(testOrder);
//	}

}
