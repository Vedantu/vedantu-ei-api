package com.vedantu.api.responses.tests;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vedantu.api.commons.Base;
import com.vedantu.api.commons.Role;
import com.vedantu.api.commons.VedantuErrorCode;
import com.vedantu.api.handlers.VedantuResponseBuilder;
import com.vedantu.api.responses.AuthResponse;
import com.vedantu.api.responses.BaseResponse;
import com.vedantu.api.responses.ClassInfo;

public class AuthResponseTests extends TestCase {

    public void testSuccessfultResponse() {

        List<ClassInfo> classes = new ArrayList<ClassInfo>();
        classes.add(new ClassInfo("TestId", -1));
        AuthResponse authRes;
        try {
            authRes = new AuthResponse("vikram", "vikram", Role.STUDENT, classes);
            Base response = VedantuResponseBuilder.getBuilder().setResponse(authRes).build();

            String json = response.deserialize();

            BaseResponse newResponse = (BaseResponse) BaseResponse.parse(json, AuthResponse.class);
            AuthResponse authResponse = (AuthResponse) newResponse.getResult();

            assertEquals(null, newResponse.getErrorCode());
            assertEquals("TestId", authResponse.getClasses().get(0).getClassCode());
        } catch (InvocationTargetException e) {

            e.printStackTrace();
        }

    }

    public void testFailedResponse() {

        List<ClassInfo> classes = new ArrayList<ClassInfo>();
        classes.add(new ClassInfo("TestId", -1));
        AuthResponse authRes;
        try {
            authRes = new AuthResponse("vikram", "vikram", Role.STUDENT, classes);
            Base response = VedantuResponseBuilder.getBuilder()
                    .setErrorCode(VedantuErrorCode.AUTHENTICATION_FAILED).setResponse(authRes)
                    .build();
            String json = response.deserialize();

            BaseResponse newResponse = (BaseResponse) BaseResponse.parse(json, AuthResponse.class);

            AuthResponse authResponse = (AuthResponse) newResponse.getResult();
            assertEquals(VedantuErrorCode.AUTHENTICATION_FAILED, newResponse.getErrorCode());

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
