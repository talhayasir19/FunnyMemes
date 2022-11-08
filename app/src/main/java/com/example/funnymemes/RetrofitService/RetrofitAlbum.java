package com.example.funnymemes.RetrofitService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAlbum {
    private static RetrofitAlbum instance = null;
    private ApiInterface api;

    private RetrofitAlbum(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiInterface.class);

    }

    public static synchronized RetrofitAlbum getInstance(){
        if (instance == null){
            instance = new RetrofitAlbum();
        }
        return instance;
    }

    public ApiInterface getApi(){
        return api;
    }
}
