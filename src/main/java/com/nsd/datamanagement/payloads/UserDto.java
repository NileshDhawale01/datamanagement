package com.nsd.datamanagement.payloads;

import lombok.Data;

@Data
public class UserDto {

	private Integer userId;

	private String userName;

	private String emial;

	private String password;
}
