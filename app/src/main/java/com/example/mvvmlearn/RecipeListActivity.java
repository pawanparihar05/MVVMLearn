package com.example.mvvmlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmlearn.model.Recipe;
import com.example.mvvmlearn.requests.RecipeAPI;
import com.example.mvvmlearn.requests.ServiceGenerator;
import com.example.mvvmlearn.requests.responses.RecipeResponse;
import com.example.mvvmlearn.requests.responses.RecipeSearchResponse;
import com.example.mvvmlearn.util.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {
    private static final String TAG = "RecipeListActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);


        findViewById(R.id.button_test).setOnClickListener(v -> {
            testRetrofitRequest();
        });
    }


    private void testRetrofitRequest() {
        RecipeAPI recipeAPI = ServiceGenerator.getRecipeAPI();

        //Search test
//        Call<RecipeSearchResponse> responseCall = recipeAPI
//                .searchRecipe(
//                        Constants.API_KEY,
//                        "chicken breast",
//                        "1"
//                );
//
//        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
//            @Override
//            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
//                Log.d(TAG, "onResponse: server response: " + response.toString());
//                if (response.code() == 200) {
//                    Log.d(TAG, "onResponse: " + response.body().toString());
//                    List<Recipe> recipes = new ArrayList<>(response.body().getRecipeList());
//                    for (Recipe recipe : recipes) {
//                        Log.d(TAG, "onResponse: " + recipe.getTitle());
//                    }
//                } else {
//                    try {
//                        Log.d(TAG, "onResponse: " + response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {
//
//            }
//        });


        //Recipe Details test
        Call<RecipeResponse> responseCall = recipeAPI
                .getRecipe(
                Constants.API_KEY,
                "30373"
        );

        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.d(TAG, "onResponse: server response: " + response.toString());
                if (response.code() == 200) {
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    Recipe recipe = response.body().getRecipe();
                    Log.d(TAG, "RetrievedRecipe: " + recipe.toString());
                } else {
                    try {
                        Log.d(TAG, "onResponse: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });
    }

}