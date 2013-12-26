package com.vedantu.ei.responses;

import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.AbstractVedantuJSONStringable;
import com.vedantu.ei.results.AbstractVedantuResult;
import com.vedantu.ei.results.BooleanResult;
import com.vedantu.ei.utils.JSONUtils;
import com.vedantu.ei.utils.StringUtils;

public class AbstractVedantuResponse extends AbstractVedantuJSONStringable
		implements IResponseValidator {

	protected static final BooleanResult NO_RESULT = new BooleanResult();

	/* enum VedantuErrorCode */
	private String errorCode;
	protected String errorMessage = StringUtils.EMPTY;
	private AbstractVedantuResult result;

	protected AbstractVedantuResponse(String errorCode, String errorMessage,
			AbstractVedantuResult result) {
		super();
		this.errorCode = null != errorCode ? errorCode : StringUtils.EMPTY;
		this.errorMessage = null != errorMessage ? errorMessage
				: StringUtils.EMPTY;
		this.result = null != result ? result : NO_RESULT;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public AbstractVedantuResult getResult() {
		return result;
	}

	public void validate() throws IllegalArgumentException {
		if (null == this.result && StringUtils.isEmpty(errorCode)) {
			throw new IllegalArgumentException(
					"Missing arguments: in AbstractVedantuResponse -- result and errorCode");
		}
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.errorCode = JSONUtils.getString(json, KEY_ERROR_CODE,
				StringUtils.EMPTY);
		this.errorMessage = JSONUtils.getString(json, KEY_ERROR_MESSAGE,
				StringUtils.EMPTY);
		/*
		 * Won't populate result if ERROR_CODE is present if you still need
		 * result call result.fromJSON() explicitly in your code
		 */
		if (StringUtils.isEmpty(this.errorCode)) {
			loadResult(json);
		}
	}

	public JSONObject toJSON() {
		validate();

		JSONObject json = new JSONObject();
		try {
			json.put(KEY_ERROR_CODE, this.errorCode);
			json.put(KEY_ERROR_MESSAGE, this.errorMessage);
			json.put(KEY_RESULT, this.result.toJSON());
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	public void loadResult(JSONObject json) throws JSONException {
		JSONObject resultJSON = (JSONObject) json.get(KEY_RESULT);
		this.result.fromJSON(resultJSON);
	}

	private static final String KEY_ERROR_CODE = "errorCode";
	private static final String KEY_ERROR_MESSAGE = "errorMessage";
	private static final String KEY_RESULT = "result";
}
