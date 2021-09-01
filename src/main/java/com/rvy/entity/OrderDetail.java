package com.rvy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "order_detail_rvy")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(4)")
	private Integer orderDetailId;
	@NotNull
	@Column(columnDefinition = "NUMERIC(4)")
	private Integer quantity;
	@Column(columnDefinition = "NUMERIC(10,2)")
	private Double sellingPrice;
//	@Column(columnDefinition = "NUMERIC(4,2)")
//	private Double discount;
//	@Column(columnDefinition = "NUMERIC(10,2)")
//	private Double sellingPriceAfterDiscount;
	@Column(columnDefinition = "NUMERIC(10,2)")
	private Double itemTotal;

	@Column(length = 10)
	private String batchCode;
	//private Integer inventoryId;


	//private String productName;
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "order_id")
	//private OrderMaster orderMaster;


}
