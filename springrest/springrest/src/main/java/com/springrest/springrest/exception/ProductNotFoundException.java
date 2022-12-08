package com.springrest.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ProductNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}
	
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	
	public ProductNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		//message diplay
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}


	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}


	
	

}
