Feature: Find Order

  Scenario: FINDING ORDER BY ID

    Given The following order exists and Admin wants to find the order by ID
      | orderId  | billNo  | orderDate         | orderAmount       | taxAmount              | billingAmount   | PaymentMode   |currencyType   | customerId       | storeId |
    	| 1  			 | 100     | 2021-03-03        | 10000.00          | 300.00                 | 9000    		    | cash          |IND            | 302              | 678     |
      | 2  			 | 101     | 2021-03-03        | 13000.00          | 330.00                 | 11000    		    | cash          |IND            | 304              | 678     |
    When admin wants to find the order with ID '1'
    Then the order is found
