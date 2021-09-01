package com.rvy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvy.entity.OrderDetail;
import com.rvy.entity.OrderMaster;
import com.rvy.exception.OrderException;
import com.rvy.repository.OrderMasterRepository;

@Service
@Transactional
public class OrderMasterServiceImpl implements OrderMasterService {
	@Autowired
	private OrderMasterRepository orderMasterRepository;

//	@Autowired
//	private DiscountMasterRepository discountMasterRepository;

	@Override
	public List<OrderMaster> getAllOrders() throws OrderException {
		try {
			return orderMasterRepository.findAll();
		} catch (Exception e) {
			throw new OrderException(e.getMessage(), e);
		}
	}
	@Override
	public OrderMaster getOrderDetailsById(Integer id)
			throws OrderException {
		try {
			return orderMasterRepository.findById(id).get();
		} catch (Exception e) {
			throw new OrderException(e.getMessage(), e);
		}
	}
	@Override
	public OrderMaster addOrder(OrderMaster order)
			throws OrderException {
		try {
			OrderMaster orderAdded =
					orderMasterRepository.save(order);
			//System.out.println(orderAdded);
			return orderAdded;
		} catch (Exception e) {
			throw new OrderException(e.getMessage(),e);
		}
	}

//	@Override
//	public OrderMaster updateOrder(OrderMaster order)
//			throws OrderException {
//		try{
//			return orderMasterRepository.save(order);
//		}catch (Exception e) {
//			throw new OrderException(e.getMessage(),e);
//		}
//	}
	@Override
	public Integer deleteOrder(Integer orderId)
			throws OrderException {
		try {
			OrderMaster order =
					orderMasterRepository.findById(orderId).get();
			orderMasterRepository.delete(order);
			return orderId;
		} catch (Exception e) {
			throw new OrderException(e.getMessage(), e);
		}
	}
//	@Override
//	public Double getTotalOrderAmount(Integer orderId) {
//		OrderMaster orderMaster =
//			orderMasterRepository.findById(orderId).get();
//		Double totalOrderAmount =
//			orderMaster.getOrderDetailList()
//			.stream().map((od)->od.getItemTotal())
//			.reduce((a,b)->a+b).get();
//		orderMaster.setOrderAmount(totalOrderAmount);
//		return orderMaster.getOrderAmount();
//	}
//	@Override
//	public Double getBillingAmount(Integer orderId) {
//		OrderMaster orderMaster =
//			orderMasterRepository.findById(orderId).get();
//		Double billableAmount =
//			orderMaster.getOrderAmount() +
//			orderMaster.getTaxAmount();
//		orderMaster.setBillingAmount(billableAmount);
//		return orderMaster.getBillingAmount();
//	}
	@Override
	public List<OrderDetail> getAllOrderDetailsByOrderId(
			Integer id
			) {

		return orderMasterRepository.findById(id)
				.get().getOrderDetailList();
	}
	@Override
	public Integer deleteOrderDetailsByOrderId(Integer id) {

		OrderMaster order =
				orderMasterRepository.findById(id).get();
		orderMasterRepository.delete(order);
		return id;
	}
//	@Override
//	public Double calculateBillingAmount(
//	Double orderAmount) {
//
//		return null;
//	}
//	@Override
//	public Double findDiscount(Double orderAmount) {
//
//		List<DiscountMaster> discountList =
//		discountMasterRepository.findAll();
//		Collections.sort( discountList, (dm1, dm2)->
//									dm1.getEligibilityCriteria()
//									.compareTo(dm2.getEligibilityCriteria())
//									);
//		String discountCode = null;
//		for(DiscountMaster discount : discountList) {
//			if (Double.parseDouble(
//				discount.getEligibilityCriteria()) <= orderAmount
//					) {
//				discountCode = discount.getDiscountCode();
//			}
//			else
//				break;
//
//		}
//		return Double.parseDouble(
//			discountCode.substring(discountCode.length()
//			-2,discountCode.length())) ;
//	//return null;
//	}



}
