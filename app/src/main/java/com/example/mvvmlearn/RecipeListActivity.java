package com.example.mvvmlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RecipeListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);


        findViewById(R.id.button_test).setOnClickListener(v -> {
            if (mProgressBar.getVisibility() == View.VISIBLE) {
                Toast.makeText(this, "vv", Toast.LENGTH_SHORT).show();
                showProgressBar(false);
            } else {
                Toast.makeText(this, "hh", Toast.LENGTH_SHORT).show();

                showProgressBar(true);
            }
        });
    }
}