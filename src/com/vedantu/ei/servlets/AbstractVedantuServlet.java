package com.vedantu.ei.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractVedantuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String CONTENT_TYPE_JSON = "application/json";

	public AbstractVedantuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
