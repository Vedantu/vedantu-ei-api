package com.vedantu.ei.results;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.enums.Gender;
import com.vedantu.ei.responses.pojos.ClassInfo;
import com.vedantu.ei.utils.CollectionUtils;
import com.vedantu.ei.utils.JSONUtils;
import com.vedantu.ei.utils.StringUtils;

public class AuthResult extends AbstractVedantuResult {

	private String userId;
	private String memberId;
	private String firstName;
	private String lastName;
	/* enum Gender */
	private String gender = Gender.UNKNOWN;
	/* enum Role */
	private String role;

	/* <ClassInfo> */
	private List classes = new ArrayList();

	public AuthResult(String userId, String firstName, String role, List classes)
			throws InvocationTargetException {

		if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(firstName)
				|| role == null || CollectionUtils.isEmpty(classes)) {
			throw new InvocationTargetException(new Throwable(
					"can not instantiate auth response with empty values"));
		}
		this.userId = userId;
		this.firstName = firstName;
		this.role = role;
		this.classes = classes;

	}

	public String getUserId() {

		return userId;
	}

	public String getMemberId() {

		return memberId;
	}

	public void setMemberId(String memberId) {

		this.memberId = memberId;
	}

	public String getFirstName() {

		return firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public String getGender() {

		return gender;
	}

	public void setGender(String gender) {

		this.gender = gender;
	}

	public String getRole() {

		return role;
	}

	public void addClassInfo(ClassInfo classInfo) {

		classes.add(classInfo);
	}

	public void addClassInfo(ClassInfo[] classInfo) {

		if (classInfo != null) {

			for (int i = 0; i < classInfo.length; i++) {
				classes.add(classInfo[i]);
			}
		}
	}

	public List getClasses() {

		return classes;
	}

	public void setClasses(List classes) {

		this.classes = classes;
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.userId = json.getString(KEY_USER_ID);
		this.memberId = JSONUtils.getString(json, KEY_MEMBER_ID, userId);
		this.firstName = json.getString(KEY_FIRST_NAME);
		this.lastName = JSONUtils.getString(json, KEY_LAST_NAME,
				StringUtils.EMPTY);
		this.gender = JSONUtils.getString(json, KEY_GENDER, Gender.UNKNOWN);
		this.role = json.getString(KEY_ROLE);

		JSONArray classesJSONArray = JSONUtils.getJSONArray(json, KEY_CLASSES,
				new JSONArray());
		for (int i = 0; i < classesJSONArray.length(); i++) {
			JSONObject classJSON = (JSONObject) classesJSONArray.get(i);
			ClassInfo classInfo = new ClassInfo();
			classInfo.fromJSON(classJSON);
			this.classes.add(classInfo);
		}
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_USER_ID, this.userId);
			json.put(KEY_MEMBER_ID, this.memberId);
			json.put(KEY_FIRST_NAME, this.firstName);
			json.put(KEY_LAST_NAME, this.lastName);
			json.put(KEY_GENDER, this.gender);
			json.put(KEY_ROLE, this.role);
			json.put(KEY_CLASSES, JSONUtils.toJSONArray(this.classes));
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	private static final String KEY_USER_ID = "userId";
	private static final String KEY_MEMBER_ID = "memberId";
	private static final String KEY_FIRST_NAME = "firstName";
	private static final String KEY_LAST_NAME = "lastName";
	private static final String KEY_GENDER = "gender";
	private static final String KEY_ROLE = "role";
	private static final String KEY_CLASSES = "classes";

}
