package com.vedantu.ei.managers.api;

import java.lang.reflect.InvocationTargetException;

import com.vedantu.ei.requests.AuthRequest;
import com.vedantu.ei.responses.AuthResponse;

public interface IUserManager extends IManager {

	AuthResponse authenticate(AuthRequest request)
			throws InvocationTargetException;

}
