package com.vedantu.ei.requests;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.AbstractVedantuJSONStringable;
import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.exceptions.VedantuException;
import com.vedantu.ei.servlets.AbstractVedantuServlet;

public abstract class AbstractVedantuRequest extends
		AbstractVedantuJSONStringable {

	public void parse(HttpServletRequest request) throws VedantuException,
			IOException, JSONException {

		if (!request.getContentType().equals(
				AbstractVedantuServlet.CONTENT_TYPE_JSON)) {
			throw new VedantuException(VedantuErrorCode.INVALID_CONTENT_TYPE,
					"contentType: " + request.getContentType() + " not allowed");
		}

		StringBuffer sb = new StringBuffer();

		BufferedReader reader = request.getReader();
		String line = null;
		while (null != (line = reader.readLine())) {
			sb.append(line);
		}

		JSONObject json = new JSONObject(sb.toString());
		fromJSON(json);
	}
}
