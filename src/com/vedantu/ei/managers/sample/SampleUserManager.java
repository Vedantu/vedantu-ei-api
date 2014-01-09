package com.vedantu.ei.managers.sample;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.vedantu.ei.commons.enums.Gender;
import com.vedantu.ei.commons.enums.Role;
import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.managers.api.IUserManager;
import com.vedantu.ei.requests.AuthRequest;
import com.vedantu.ei.requests.RegRequest;
import com.vedantu.ei.responses.AuthResponse;
import com.vedantu.ei.responses.RegResponse;
import com.vedantu.ei.responses.pojos.ClassInfo;
import com.vedantu.ei.results.AuthResult;
import com.vedantu.ei.results.RegResult;
import com.vedantu.ei.utils.CollectionUtils;
import com.vedantu.ei.utils.StringUtils;

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

	public RegResponse register(RegRequest request)
			throws InvocationTargetException {
		RegResponse response;

		RegResult result = new RegResult();

		if (hasMissingParameters(request, result)) {
			response = new RegResponse(VedantuErrorCode.MISSING_PARAMETERS, "",
					result);
		} else if (isAlreadyRegistered(request.getUsername())) {

			response = new RegResponse(VedantuErrorCode.USER_ALREADY_EXISTS,
					"", null);

		} else {
			result = registerUser(request);
			response = new RegResponse(null, null, result);
		}

		return response;
	}

	private boolean hasMissingParameters(RegRequest request, RegResult result) {
		// Some values that should always be sent
		if (StringUtils.isEmpty(request.getUsername())) {
			result.addMissingParameter(RegRequest.KEY_USERNAME);
		}
		if (StringUtils.isEmpty(request.getPassword())) {
			result.addMissingParameter(RegRequest.KEY_PASSWORD);
		}
		if (StringUtils.isEmpty(request.getFirstName())) {
			result.addMissingParameter(RegRequest.KEY_FIRST_NAME);
		}
		if (StringUtils.isEmpty(request.getRole())) {
			result.addMissingParameter(RegRequest.KEY_ROLE);
		}

		// If you want any other checks -->
		if (!request.getAdditionalInfo().containsKey("CAT Roll Number")) {
			result.addMissingParameter(RegRequest.KEY_ADDITIONAL_INFO + "/"
					+ "CAT Roll Number");
		}

		return !CollectionUtils.isEmpty(result.getMissingParameters());
	}

	private boolean isAlreadyRegistered(String username) {
		return username.equals("MBA2013999");
	}

	private RegResult registerUser(RegRequest request) {
		// perform steps to register user
		// <your steps>
		// <your steps>
		// ...

		RegResult result = new RegResult();

		// set mandatory fields
		result.setUserId("654321abc");

		// set non-mandatory fields
		result.setMemberId("MBA2013666");

		return result;
	}

}
