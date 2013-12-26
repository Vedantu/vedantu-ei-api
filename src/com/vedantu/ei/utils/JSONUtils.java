package com.vedantu.ei.utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.JSONAware;

public class JSONUtils {

	public static String getString(JSONObject json, String key,
			String defaultValue) {

		String value = defaultValue;
		if (json == null) {
			return value;
		}
		try {
			value = json.getString(key);
			if (value == null) {
				value = StringUtils.EMPTY;
			}
		} catch (JSONException e) {
			// swallow
		}
		return value;
	}

	public static JSONArray getJSONArray(JSONObject json, String key,
			JSONArray defaultValue) {

		JSONArray value = defaultValue;
		try {
			if (json.has(key)) {
				value = json.getJSONArray(key);
				if (value == null) {
					value = new JSONArray();
				}
			}
		} catch (JSONException e) {
			// swallow
		}
		return value;
	}

	public static JSONArray toJSONArray(List jsonAwares) {

		JSONArray jsonArray = new JSONArray();
		if (!CollectionUtils.isEmpty(jsonAwares)) {
			for (int i = 0; i < jsonAwares.size(); i++) {
				JSONAware jsonAware = (JSONAware) jsonAwares.get(i);
				jsonArray.put(jsonAware.toJSON());
			}
		}
		return jsonArray;
	}

}
