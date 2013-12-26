package com.vedantu.ei.commons;

import org.json.JSONObject;

public abstract class AbstractVedantuJSONStringable implements JSONAware {

	public final String toJSONString() {

		JSONObject json = toJSON();
		return json.toString();
	}
}
