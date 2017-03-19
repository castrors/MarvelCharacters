package com.castrodev.marvelcharacters.api;

import com.castrodev.marvelcharacters.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rodrigocastro on 18/03/17.
 */

public class ApiClient {

    public static final String BASE_URL = "http://gateway.marvel.com/v1/public/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    public static Map<String, String> getData() {
        Map<String, String> data = new HashMap<>();
        data.put("ts", BuildConfig.TIME_STAMP_PARAM);
        data.put("apikey", BuildConfig.API_KEY_PARAM);
        data.put("hash", BuildConfig.HASH_PARAM);

        return data;
    }


}
