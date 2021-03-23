package com.example.mvvmlearn;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

// abstract allows to use this activity as a base activity and avoid adding it into manifest
// by disabling instantiated
public abstract class BaseActivity extends AppCompatActivity {

    public ProgressBar mProgressBar;

    @Override
    public void setContentView(int layoutResID) {
        //inflate parent layout
        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        //get frame layout for content
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_content);
        mProgressBar = constraintLayout.findViewById(R.id.progress_bar);

        // associate the frame layout with base activity so the frame layout acts as a container for the child activities
        getLayoutInflater().inflate(layoutResID, frameLayout, true);
        super.setContentView(constraintLayout);
    }

    //control the common progress bar
    public void showProgressBar(boolean shouldShow) {
        mProgressBar.setVisibility(shouldShow ? View.VISIBLE : View.INVISIBLE);
    }
}
