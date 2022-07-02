package com.blogging.sanit.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ApiResponse {
	
	private String msg;
	private boolean isSuccess;

}
