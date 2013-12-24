package com.vedantu.ei.requests;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.exceptions.VedantuException;
import com.vedantu.ei.servlets.AbstractVedantuServlet;
import com.vedantu.ei.utils.GsonUtils;

public abstract class AbstractVedantuRequest {

	public AbstractVedantuRequest() {

	}

	protected static <T> T parse(HttpServletRequest request, Class<T> classType)
			throws VedantuException, IOException {

		if (!request.getContentType().equals(
				AbstractVedantuServlet.CONTENT_TYPE_JSON)) {
			throw new VedantuException(VedantuErrorCode.INVALID_CONTENT_TYPE,
					"contentType: " + request.getContentType() + " not allowed");
		}

		StringBuilder sb = new StringBuilder();

		BufferedReader reader = request.getReader();
		String line = null;
		while (null != (line = reader.readLine())) {
			sb.append(line);
		}

		return GsonUtils.getGson().fromJson(sb.toString(), classType);

	}
}
