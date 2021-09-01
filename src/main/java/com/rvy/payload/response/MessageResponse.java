package com.rvy.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageResponse {
	private String message;
	private Integer orderId;
	
	public MessageResponse(String message) {
		this.message = message;
	}
}
