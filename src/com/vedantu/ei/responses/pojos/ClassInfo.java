package com.vedantu.ei.responses.pojos;

public class ClassInfo {

	private String classCode;
	private long expiry;

	public ClassInfo(String classCode, long expiry) {

		super();
		this.classCode = classCode;
		this.expiry = expiry;
	}

	public String getClassCode() {

		return classCode;
	}

	public long getExpiry() {

		return expiry;
	}

	public void setExpiry(long expiry) {

		this.expiry = expiry;
	}

}
