package com.rvy.cucumber.bdd.stepdefs;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rvy.entity.OrderMaster;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

/**
 * Step Definition Class for Employee.
 *
 * <p>Uses Java Lambda style step definitions so that we don't need to worry
 * about method naming for each step definition</p>
 */
public class FindOrderSteps extends AbstractSteps implements En {
	
	boolean notNull = false;
	@Autowired
	OrderMaster order;
	List<OrderMaster> orderList = new ArrayList<OrderMaster>();
	boolean found = false;
  public FindOrderSteps() {
	  
	  
	  
    Given("The following order exists and Admin wants to find the order by ID", (DataTable orderDt) -> {
      testContext().reset();
      
      List<List<String>> orderData = orderDt.asLists(String.class);
      // First row of DataTable has the employee attributes hence calling get(0) method.
//      for(List<String> e: customerList) {
//    	  System.out.println(e);
//      }
//      System.out.println(customerData.get(1));
      
//      super.testContext()
//          .setPayload(customerList.get(0));
      
      orderList.add(populateOrder(orderData.get(1)));
      orderList.add(populateOrder(orderData.get(2)));
      
    });

    When("admin wants to find the order with ID {string}", (String id) -> {
//      String createCustomerUrl = "rvy/api/cm/v1/customers";
//
//      // AbstractSteps class makes the POST call and stores response in TestContext
//      executePost(createCustomerUrl);
    	Integer ordId = Integer.parseInt(id);
    	for(OrderMaster c: orderList) {
    		if(c.getOrderId().equals(ordId)) {
    			found =true;
    		}
    	}
    	
    });

    /**
     * This can be moved to a Class named 'CommonSteps.java so that it can be reused.
     */
    Then("the order is found", () -> {
//      Response response = testContext().getResponse();
//
//      switch (expectedResult) {
//        case "IS SUCCESSFUL":
//          assertThat(response.statusCode()).isIn(200, 201);
//          break;
//        case "FAILS":
//          assertThat(response.statusCode()).isBetween(400, 504);
//          break;
//        default:
//          fail("Unexpected error");
    	assertTrue(found);
//      }
    	
    });

  }

  private OrderMaster populateOrder(List<String> list) {
		OrderMaster order = new OrderMaster();
		
		order.setOrderId(Integer.parseInt(list.get(0)));
		order.setBillNo(Integer.parseInt(list.get(1)));
		order.setOrderDate(LocalDate.parse(list.get(2)));
		order.setOrderAmount(Double.parseDouble(list.get(3)));
		order.setTaxAmount(Double.parseDouble(list.get(4)));

		order.setBillingAmount(Double.parseDouble(list.get(5)));
		order.setPaymentMode(list.get(6));
		order.setCurrencyType(list.get(7));
		order.setCustomerId(Integer.parseInt(list.get(8)));
		order.setStoreId(Integer.parseInt(list.get(9)));

		return order;
	}
}

