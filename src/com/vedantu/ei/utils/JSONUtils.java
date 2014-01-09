package com.vedantu.ei.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

	/* <String, Object> */
	public static Map toMap(JSONObject json, String key) {
		if (null == json) {
			return null;
		}
		if (!StringUtils.isEmpty(key) && !json.has(key)) {
			return null;
		}
		Map jsonMap = new HashMap();
		JSONObject convertible = StringUtils.isEmpty(key) ? json
				: (JSONObject) json.get(key);
		Iterator keysIterator = convertible.keys();
		while (keysIterator.hasNext()) {
			String k = (String) keysIterator.next();
			Object v = convertible.get(k);
			jsonMap.put(k, v);
		}
		return jsonMap;
	}

}
