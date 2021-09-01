package com.rvy.payload.response;

import java.time.LocalDate;
import java.util.List;

import com.rvy.entity.OrderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderResponse {
	private Integer orderId;
	private Integer billNo;
	private LocalDate orderDate;
	private Double orderAmount;
	private Double taxAmount;
	private Double discountPercent;
	private Double billingAmount;
	private String paymentMode;
	private String currencyType;
	private Integer customerId;
	private Integer storeId;
	private List<OrderDetail> orderDetails;
}
