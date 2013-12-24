package com.vedantu.api.requests.tests;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

import com.vedantu.api.requests.AuthRequest;

public class AuthRequestTest extends TestCase{

    @Test
    public void testAuthRequestTest() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("userName", "vikram");
        params.put("password", "value");
        
        AuthRequest request = AuthRequest.parse(params);
        
        assertEquals("vikram",request.getUserName());
                
    }
}
