package com.vedantu.ei.responses;

public interface IResponseValidator {

	/**
	 * Validate all the mandatory fields in the response object as the first
	 * thing in the toJSON() call and throw exception in case mandatory params
	 * are missing.
	 * 
	 * @throws IllegalArgumentException
	 */
	void validate() throws IllegalArgumentException;

}
