package com.vedantu.ei.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.vedantu.ei.exceptions.VedantuException;
import com.vedantu.ei.requests.pojos.Attempt;

public class UploadTestAttemptsRequest extends AbstractVedantuRequest {

	private String uploadId;
	private List<Attempt> attempts = new ArrayList<Attempt>();

	public String getUploadId() {

		return uploadId;
	}

	public void setUploadId(String uploadId) {

		this.uploadId = uploadId;
	}

	public List<Attempt> getAttempts() {

		return attempts;
	}

	public void setAttempts(List<Attempt> attempts) {

		this.attempts = attempts;
	}

	public void addAttempts(Attempt... attempts) {

		if (attempts != null) {
			for (int i = 0; i < attempts.length; i++) {
				this.attempts.add(attempts[i]);
			}
		}
	}

	public void addAttempt(Attempt attempt) {

		this.attempts.add(attempt);
	}

	public static UploadTestAttemptsRequest parse(HttpServletRequest request)
			throws VedantuException, IOException {

		return parse(request, UploadTestAttemptsRequest.class);
	}
}
