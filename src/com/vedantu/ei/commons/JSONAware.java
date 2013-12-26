package com.vedantu.ei.commons;

import org.json.JSONException;
import org.json.JSONObject;

public interface JSONAware {
	
	void fromJSON(JSONObject json) throws JSONException;
	
	JSONObject toJSON();

}
