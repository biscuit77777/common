package com.biscuit.common.factory;

import com.google.gson.Gson;

/**
 * @author biscuit
 */
public abstract class GsonFactory {

    private static final Gson INSTANCE = new Gson();

    public static Gson get() {
        return INSTANCE;
    }

}