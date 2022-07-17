package com.blogging.sanit.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String userName;
	private String password;
}
