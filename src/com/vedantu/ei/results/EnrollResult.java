package com.vedantu.ei.results;

import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.responses.pojos.ClassInfo;

public class EnrollResult extends AbstractVedantuResult {

	public ClassInfo classInfo;

	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public void validate() throws IllegalArgumentException {
		if (null == classInfo) {
			throw new IllegalArgumentException(
					"Missing arguments: in EnrollResult -- classInfo");
		}
	}

	public void fromJSON(JSONObject json) throws JSONException {
		classInfo = new ClassInfo();
		classInfo.fromJSON(json);
	}

	public JSONObject toJSON() {
		validate();

		return classInfo.toJSON();
	}

}
