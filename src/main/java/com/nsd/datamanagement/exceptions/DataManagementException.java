package com.nsd.datamanagement.exceptions;

import lombok.Data;

@Data
public class DataManagementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resource;

	private String fielName;

	private Integer value;

	public DataManagementException() {
		super();
	}

	public DataManagementException(String resource, String fieldName, Integer value) {
		super(String.format("%s not found with %s : %s", resource, fieldName, value));
		this.resource = resource;
		this.fielName = fieldName;
		this.value = value;
	}

	public DataManagementException(String resource, String fieldName) {
		super(String.format("%s not found with %s ", resource, fieldName));
		this.resource = resource;
		this.fielName = fieldName;
	}
}
