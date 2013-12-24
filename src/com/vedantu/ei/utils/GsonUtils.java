package com.vedantu.ei.utils;

import com.google.gson.Gson;

public class GsonUtils {

    private static Gson gson;
    static {
        gson = new Gson();
    }

    public static Gson getGson() {

        return gson;
    }
}
