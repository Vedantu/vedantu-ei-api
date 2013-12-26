package com.vedantu.ei.results;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.vedantu.ei.commons.enums.Gender;
import com.vedantu.ei.commons.enums.Role;
import com.vedantu.ei.responses.pojos.ClassInfo;
import com.vedantu.ei.utils.CollectionUtils;
import com.vedantu.ei.utils.StringUtils;

public class AuthResult extends AbstractVedantuResult {

	private String userId;
	private String memberId;
	private String firstName;
	private String lastName;
	private Gender gender = Gender.UNKNOWN;
	private Role role;

	private List<ClassInfo> classes = new ArrayList<ClassInfo>();

	public AuthResult(String userId, String firstName, Role role,
			List<ClassInfo> classes) throws InvocationTargetException {

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

	public Gender getGender() {

		return gender;
	}

	public void setGender(Gender gender) {

		this.gender = gender;
	}

	public Role getRole() {

		return role;
	}

	public void addClassInfo(ClassInfo classInfo) {

		classes.add(classInfo);
	}

	public void addClassInfo(ClassInfo... classInfo) {

		if (classInfo != null) {

			for (int i = 0; i < classInfo.length; i++) {
				classes.add(classInfo[i]);
			}
		}
	}

	public List<ClassInfo> getClasses() {

		return classes;
	}

	public void setClasses(List<ClassInfo> classes) {

		this.classes = classes;
	}

}
