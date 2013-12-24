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

	@Override
	public AuthResponse authenticate(AuthRequest request)
			throws InvocationTargetException {
		AuthResponse response;
		if (request.getUsername().equals("MBA2013999")
				&& request.getPassword().equals("somesecret")) {

			List<ClassInfo> classes = new ArrayList<ClassInfo>();
			classes.add(new ClassInfo("TestId", 62222222222L));

			AuthResult result = new AuthResult("654321abc", "Anthony",
					Role.STUDENT, classes);

			result.setLastName("Gonsalves");
			result.setGender(Gender.MALE);
			result.setMemberId("MBA2013999");

			response = new AuthResponse(null, null, result);

		} else {
			response = new AuthResponse(VedantuErrorCode.AUTHENTICATION_FAILED,
					"auth failure", null);
		}
		return response;
	}

}
