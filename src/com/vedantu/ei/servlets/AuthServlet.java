package com.vedantu.ei.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vedantu.ei.exceptions.VedantuException;
import com.vedantu.ei.managers.api.ManagerFactory;
import com.vedantu.ei.requests.AuthRequest;
import com.vedantu.ei.responses.AuthResponse;
import com.vedantu.ei.responses.ErrorResponse;

public class AuthServlet extends AbstractVedantuServlet {

	private static final long serialVersionUID = 1L;

	public AuthServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType(CONTENT_TYPE_JSON);

		PrintWriter writer = response.getWriter();

		try {
			AuthRequest authRequest = AuthRequest.parse(request);

			AuthResponse authResponse = ManagerFactory.INSTANCE
					.getUserManager().authenticate(authRequest);

			writer.write(authResponse.toJSONString());

		} catch (VedantuException e) {
			writer.write(new ErrorResponse(e).toJSONString());
		} catch (Throwable t) {
			writer.write(new ErrorResponse(t).toJSONString());
			throw new ServletException(t);
		} finally {
			writer.close();
		}
	}

}
