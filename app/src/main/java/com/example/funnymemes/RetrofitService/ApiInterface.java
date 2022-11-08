package com.example.funnymemes.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

//    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static final String BASE_URL = "https://fakestoreapi.com/";


//    @GET("photos")
    @GET("products")
    Call<List<RetrofitModel>> getProducts();

}
