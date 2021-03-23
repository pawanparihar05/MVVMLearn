package com.example.mvvmlearn.requests;

import com.example.mvvmlearn.requests.responses.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeAPI {

    //SEARCH
    @GET("api/search")
    Call<RecipeSearchResponse> searchRecipe(
            @Query("key") String key,
            @Query("q") String query,
            @Query("page") String page
    );

    //GET RECIPE
    @GET("api/get")
    Call<RecipeSearchResponse> getRecipe(
            @Query("key") String key,
            @Query("rid") String recipe_id
    );


}
