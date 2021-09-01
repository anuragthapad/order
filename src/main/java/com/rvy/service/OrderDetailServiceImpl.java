//package com.rvy.service;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.rvy.entity.OrderDetail;
//
//import com.rvy.exception.OrderException;
//import com.rvy.repository.OrderDetailRepository;
//
//
//@Service
//@Transactional
//public class OrderDetailServiceImpl implements OrderDetailService {
//	@Autowired
//	private OrderDetailRepository orderDetailRepository;
//
//	@Override
//	public List<OrderDetail> getAllOrders() throws OrderException {
//		try {
//			return orderDetailRepository.findAll();
//		} catch (Exception e) {
//			throw new OrderException(e.getMessage(),e);
//		}
//	}
//
//	@Override
//	public OrderDetail getOrderDetailsById(Integer id)
//	throws OrderException {
//		try {
//			return orderDetailRepository.findById(id).get();
//		} catch (Exception e) {
//			throw new OrderException(e.getMessage(),e);
//		}
//	}
//
//	@Override
//	public OrderDetail addOrderDetail(OrderDetail order)
//	throws OrderException {
//		try {
//			return orderDetailRepository.save(order);
//		} catch (Exception e) {
//			throw new OrderException(e.getMessage(),e);
//		}
//	}
//
//	@Override
//	public OrderDetail updateOrderDetail(OrderDetail order)
//	throws OrderException {
//		try {
//			return orderDetailRepository.save(order);
//		} catch (Exception e) {
//			throw new OrderException(e.getMessage(),e);
//		}
//	}
//
//	@Override
//	public Integer deleteOrder(Integer orderDetailId)
//	throws OrderException {
//		try {
//			OrderDetail order =
//				orderDetailRepository.findById(orderDetailId).get();
//			orderDetailRepository.delete(order);
//			return orderDetailId;
//		} catch (Exception e) {
//			throw new OrderException(e.getMessage(),e);
//		}
//	}
//
//
//}
