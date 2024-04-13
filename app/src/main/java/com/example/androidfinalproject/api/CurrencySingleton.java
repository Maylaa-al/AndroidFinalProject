package com.example.androidfinalproject.api;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class CurrencySingleton {

    public static CurrencySingleton instance;
    private RequestQueue requestQueue;
    private static Context context;

    private CurrencySingleton(Context context) {
        this.context = context;
    }

    public static CurrencySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new CurrencySingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
}
