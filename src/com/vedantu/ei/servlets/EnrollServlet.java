package com.vedantu.ei.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vedantu.ei.exceptions.VedantuException;
import com.vedantu.ei.managers.api.ManagerFactory;
import com.vedantu.ei.requests.EnrollRequest;
import com.vedantu.ei.responses.EnrollResponse;
import com.vedantu.ei.responses.ErrorResponse;

public class EnrollServlet extends AbstractVedantuServlet {

	private static final long serialVersionUID = 1L;

	public EnrollServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType(CONTENT_TYPE_JSON);

		PrintWriter writer = response.getWriter();

		try {
			EnrollRequest enrollRequest = new EnrollRequest();
			enrollRequest.parse(request);

			EnrollResponse enrollResponse = ManagerFactory.INSTANCE
					.getUserManager().enroll(enrollRequest);

			writer.write(enrollResponse.toJSONString());

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
