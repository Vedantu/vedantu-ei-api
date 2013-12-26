package com.vedantu.ei.managers.sample;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.vedantu.ei.commons.enums.Gender;
import com.vedantu.ei.commons.enums.Role;
import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.managers.api.IUserManager;
import com.vedantu.ei.requests.AuthRequest;
import com.vedantu.ei.responses.AuthResponse;
import com.vedantu.ei.responses.pojos.ClassInfo;
import com.vedantu.ei.results.AuthResult;

public class SampleUserManager implements IUserManager {

	public AuthResponse authenticate(AuthRequest request)
			throws InvocationTargetException {
		AuthResponse response;

		if (isAuthenticated(request.getUsername(), request.getPassword())) {

			AuthResult result = getUserDetails(request.getUsername());

			response = new AuthResponse(null, null, result);

		} else {
			response = new AuthResponse(VedantuErrorCode.AUTHENTICATION_FAILED,
					"auth failure", null);
		}
		return response;
	}

	private boolean isAuthenticated(String username, String password) {
		return username.equals("MBA2013999") && password.equals("somesecret");
	}

	private AuthResult getUserDetails(String username) {
		AuthResult result = new AuthResult();

		// set mandatory fields
		result.setUserId("654321abc");
		result.setFirstName("Anthony");
		result.setRole(Role.STUDENT);

		// set non-mandatory fields
		result.setLastName("Gonsalves");
		result.setGender(Gender.MALE);
		result.setMemberId("MBA2013999");

		// fetch user classes
		List classes = getUserClasses(username);
		result.setClasses(classes);

		return result;
	}

	private List getUserClasses(String username) {
		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassCode("Class-MBA2013");
		classInfo.setExpiry(62222222222L);

		/* <ClassInfo> */
		List classes = new ArrayList();
		classes.add(classInfo);
		return classes;
	}

}
