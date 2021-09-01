package com.rvy.service;

import java.util.List;

import com.rvy.entity.OrderDetail;
import com.rvy.entity.OrderMaster;
import com.rvy.exception.OrderException;

public interface OrderMasterService {
	List<OrderMaster> getAllOrders() throws OrderException;
	OrderMaster getOrderDetailsById(Integer id) throws OrderException;
	OrderMaster addOrder(OrderMaster order) throws OrderException;
//	OrderMaster updateOrder(OrderMaster order) throws OrderException;
	Integer deleteOrder(Integer orderId) throws OrderException;
//	Double getTotalOrderAmount(Integer orderId);
//	Double getBillingAmount(Integer orderId);
	List<OrderDetail> getAllOrderDetailsByOrderId(Integer id);
	Integer deleteOrderDetailsByOrderId(Integer id);
//	Double calculateBillingAmount(Double orderAmount);
}
