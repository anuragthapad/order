package com.rvy.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "order_master_rvy")
public class OrderMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(4)")
	private Integer orderId;
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(20)")
	private Integer billNo;
	private LocalDate orderDate;
	@Column(columnDefinition = "NUMERIC(10,2)")
	private Double orderAmount;
	@Column(columnDefinition = "NUMERIC(10,2)")
	private Double taxAmount;
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "discount_master_id")
//	private DiscountMaster discountMaster;
	private Double discountPercent;
	@Column(columnDefinition = "NUMERIC(10,2)")
	private Double billingAmount;

	@NotBlank
	@Column(length = 20)
	private String paymentMode;
	@Column(length = 20)
	@NotBlank
	private String currencyType;

	//@Column(columnDefinition = "NUMERIC(4)")
	//@JsonIgnore
	private Integer customerId;

	//@Column(columnDefinition = "NUMERIC(4)")
	//@JsonIgnore
	private Integer storeId;


	@OneToMany(targetEntity = OrderDetail.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "orderId")
	private List<OrderDetail> orderDetailList;

	public OrderMaster(Integer billNo, LocalDate orderDate,
			Double orderAmount, Double taxAmount,
			Double billingAmount, String paymentMode,
			String currencyType, Integer customerId,
			Integer storeId) {
		super();
		this.billNo = billNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.taxAmount = taxAmount;
//		this.discountMaster = discountMaster;
		this.billingAmount = billingAmount;
		this.paymentMode = paymentMode;
		this.currencyType = currencyType;
		this.customerId = customerId;
		this.storeId = storeId;
	}

	public OrderMaster(Integer orderId, Integer billNo,
			LocalDate orderDate, Double orderAmount,
			Double taxAmount, Double billingAmount,
			String paymentMode, String currencyType,
			Integer customerId, Integer storeId) {
		super();
		this.orderId = orderId;
		this.billNo = billNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.taxAmount = taxAmount;
		this.billingAmount = billingAmount;
		this.paymentMode = paymentMode;
		this.currencyType = currencyType;
		this.customerId = customerId;
		this.storeId = storeId;
	}

	public OrderMaster(Integer orderId, Double discountPercent) {
		super();
		this.orderId = orderId;
		this.discountPercent = discountPercent;
	}

	// Added a new constructor
	public OrderMaster(Integer billNo, LocalDate orderDate,
			Double orderAmount, Double taxAmount,
			Double discountPercent, Double billingAmount,
			String paymentMode, String currencyType,
			Integer customerId, Integer storeId){
		super();
		this.billNo = billNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.taxAmount = taxAmount;
		this.discountPercent = discountPercent;
		this.billingAmount = billingAmount;
		this.paymentMode = paymentMode;
		this.currencyType = currencyType;
		this.customerId = customerId;
		this.storeId = storeId;

	}


}
