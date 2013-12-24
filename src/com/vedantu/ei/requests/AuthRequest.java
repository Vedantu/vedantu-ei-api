package com.vedantu.ei.requests;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.vedantu.ei.exceptions.VedantuException;

public class AuthRequest extends AbstractVedantuRequest {

	private String username;
	private String password;

	public AuthRequest() {

		super();
	}

	public AuthRequest(String userName, String password) {

		super();
		this.username = userName;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static AuthRequest parse(HttpServletRequest request)
			throws VedantuException, IOException {

		return parse(request, AuthRequest.class);
	}
}
