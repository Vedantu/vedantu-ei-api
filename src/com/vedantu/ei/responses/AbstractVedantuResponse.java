package com.vedantu.ei.responses;

import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.requests.AbstractVedantuRequest;
import com.vedantu.ei.results.AbstractVedantuResult;
import com.vedantu.ei.results.NoResult;
import com.vedantu.ei.utils.StringUtils;

public class AbstractVedantuResponse extends AbstractVedantuRequest {

	protected static final NoResult NO_RESULT = new NoResult();

	private String errorCode;
	protected String errorMessage = StringUtils.EMPTY;
	private AbstractVedantuResult result;

	protected AbstractVedantuResponse(VedantuErrorCode errorCode,
			String errorMessage, AbstractVedantuResult result) {

		super();
		this.errorCode = null != errorCode ? errorCode.name()
				: StringUtils.EMPTY;
		this.errorMessage = null != errorMessage ? errorMessage
				: StringUtils.EMPTY;
		this.result = null != result ? result : NO_RESULT;
	}

	public VedantuErrorCode getErrorCode() {

		return StringUtils.isEmpty(errorCode) ? null : VedantuErrorCode
				.valueOf(errorCode);
	}

	public String getErrorMessage() {

		return errorMessage;
	}

	public AbstractVedantuResult getResult() {

		return result;
	}

}
