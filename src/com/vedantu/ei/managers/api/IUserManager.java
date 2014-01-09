package com.vedantu.ei.managers.api;

import java.lang.reflect.InvocationTargetException;

import com.vedantu.ei.requests.AuthRequest;
import com.vedantu.ei.requests.EnrollRequest;
import com.vedantu.ei.requests.RegRequest;
import com.vedantu.ei.responses.AuthResponse;
import com.vedantu.ei.responses.EnrollResponse;
import com.vedantu.ei.responses.RegResponse;

public interface IUserManager extends IManager {

	AuthResponse authenticate(AuthRequest request)
			throws InvocationTargetException;

	RegResponse register(RegRequest request) throws InvocationTargetException;

	EnrollResponse enroll(EnrollRequest request)
			throws InvocationTargetException;

}
