package com.vedantu.ei.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vedantu.ei.exceptions.VedantuException;
import com.vedantu.ei.managers.api.ManagerFactory;
import com.vedantu.ei.requests.RegRequest;
import com.vedantu.ei.responses.ErrorResponse;
import com.vedantu.ei.responses.RegResponse;

public class RegServlet extends AbstractVedantuServlet {

	private static final long serialVersionUID = 1L;

	public RegServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType(CONTENT_TYPE_JSON);

		PrintWriter writer = response.getWriter();

		try {
			RegRequest regRequest = new RegRequest();
			regRequest.parse(request);

			RegResponse regResponse = ManagerFactory.INSTANCE.getUserManager()
					.register(regRequest);

			writer.write(regResponse.toJSONString());

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
